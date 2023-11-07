package me.nathanfallet.usecases.models.repositories

import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IModelRepositoryTest {

    @Test
    fun testCreate() {
        val repository = object : IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override fun get(id: Long): ModelTest? {
                throw NotImplementedError()
            }

            override fun create(payload: CreatePayloadTest): ModelTest {
                return ModelTest(1, payload.value)
            }

            override fun update(id: Long, payload: UpdatePayloadTest): Boolean {
                throw NotImplementedError()
            }

            override fun delete(id: Long): Boolean {
                throw NotImplementedError()
            }
        }
        assertEquals(
            ModelTest(1, "test"),
            repository.create(CreatePayloadTest("test"), Unit)
        )
    }

}