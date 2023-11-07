package me.nathanfallet.usecases.models.repositories

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IModelSuspendRepositoryTest {

    @Test
    fun testCreate() = runBlocking {
        val repository = object : IModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override suspend fun get(id: Long): ModelTest? {
                throw NotImplementedError()
            }

            override suspend fun create(payload: CreatePayloadTest): ModelTest {
                return ModelTest(1, payload.value)
            }

            override suspend fun update(id: Long, payload: UpdatePayloadTest): Boolean {
                throw NotImplementedError()
            }

            override suspend fun delete(id: Long): Boolean {
                throw NotImplementedError()
            }
        }
        assertEquals(
            ModelTest(1, "test"),
            repository.create(CreatePayloadTest("test"), Unit)
        )
    }

}