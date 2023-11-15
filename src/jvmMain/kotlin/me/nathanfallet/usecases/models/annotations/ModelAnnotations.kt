package me.nathanfallet.usecases.models.annotations

import me.nathanfallet.usecases.models.IChildModel
import kotlin.reflect.KCallable
import kotlin.reflect.KClass

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

}
