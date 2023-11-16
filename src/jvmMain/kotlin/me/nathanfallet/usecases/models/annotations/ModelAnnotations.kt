package me.nathanfallet.usecases.models.annotations

import me.nathanfallet.usecases.models.IChildModel
import kotlin.reflect.KCallable
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubtypeOf
import kotlin.reflect.typeOf

object ModelAnnotations {

    private inline fun <reified O : Annotation> getAnnotatedMembersSorted(kClass: KClass<*>): List<Pair<KCallable<*>, O>> {
        return kClass.members.mapNotNull { member ->
            val annotation = member.annotations.firstNotNullOfOrNull {
                it as? O
            } ?: return@mapNotNull null
            Pair(member, annotation)
        }.sortedBy { (member, _) ->
            kClass.constructors.firstOrNull {
                it.parameters.any { parameter ->
                    parameter.name == member.name
                }
            }?.parameters?.indexOfFirst { it.name == member.name }
        }
    }

    fun <Model : IChildModel<*, *, *, *>> modelKeys(modelClass: KClass<Model>): List<ModelKey> {
        return getAnnotatedMembersSorted<ModelProperty>(modelClass).map { (member, annotation) ->
            ModelKey(member.name, annotation.type, annotation.style)
        }
    }

    fun <Model : IChildModel<*, *, UpdatePayload, *>, UpdatePayload : Any> updatePayloadKeys(
        modelClass: KClass<Model>,
        updatePayloadClass: KClass<UpdatePayload>
    ): List<PayloadKey> {
        return getAnnotatedMembersSorted<ModelProperty>(modelClass).mapNotNull { (member, a) ->
            val annotation = a.takeIf { it.visibleOnUpdate } ?: return@mapNotNull null
            PayloadKey(member.name, annotation.type, annotation.style, false)
        } + getAnnotatedMembersSorted<PayloadProperty>(updatePayloadClass).map { (member, annotation) ->
            PayloadKey(member.name, annotation.type, annotation.style, true)
        }
    }

    fun <Model : IChildModel<*, CreatePayload, *, *>, CreatePayload : Any> createPayloadKeys(
        modelClass: KClass<Model>,
        createPayloadClass: KClass<CreatePayload>
    ): List<PayloadKey> {
        return getAnnotatedMembersSorted<PayloadProperty>(createPayloadClass).map { (member, annotation) ->
            PayloadKey(member.name, annotation.type, annotation.style, true)
        }
    }

    fun <Output : Any> constructPayload(type: KClass<Output>, stringValues: Map<String, String>): Output? {
        val constructor = type.constructors.firstOrNull {
            it.parameters.all { parameter ->
                parameter.name in stringValues.keys
                        || parameter.isOptional
                        || parameter.type.isSubtypeOf(typeOf<Boolean>())
            }
        } ?: return null
        val params = constructor.parameters.associateWith {
            it.name?.let { name ->
                when (it.type) {
                    typeOf<Byte>(), typeOf<Byte?>() -> stringValues[name]?.toByteOrNull()
                    typeOf<UByte>(), typeOf<UByte?>() -> stringValues[name]?.toUByteOrNull()
                    typeOf<Short>(), typeOf<Short?>() -> stringValues[name]?.toShortOrNull()
                    typeOf<UShort>(), typeOf<UShort?>() -> stringValues[name]?.toUShortOrNull()
                    typeOf<Int>(), typeOf<Int?>() -> stringValues[name]?.toIntOrNull()
                    typeOf<UInt>(), typeOf<UInt?>() -> stringValues[name]?.toUIntOrNull()
                    typeOf<Long>(), typeOf<Long?>() -> stringValues[name]?.toLongOrNull()
                    typeOf<ULong>(), typeOf<ULong?>() -> stringValues[name]?.toULongOrNull()
                    typeOf<Char>(), typeOf<Char?>() -> stringValues[name]?.singleOrNull()
                    typeOf<Float>(), typeOf<Float?>() -> stringValues[name]?.toFloatOrNull()
                    typeOf<Double>(), typeOf<Double?>() -> stringValues[name]?.toDoubleOrNull()
                    typeOf<Boolean>() -> !listOf("false", null).contains(stringValues[name])
                    typeOf<Boolean?>() -> stringValues[name]?.let { b -> b != "false" }
                    else -> stringValues[name]
                }
            }
        }
        return constructor.callBy(params)
    }

}
