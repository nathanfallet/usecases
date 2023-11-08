package me.nathanfallet.usecases.models.repositories

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IModelSuspendRepositoryTest {

    @Test
    fun testGet() = runBlocking {
        val repository = object : IModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override suspend fun get(id: Long): ModelTest {
                return ModelTest(1, "test")
            }

            override suspend fun create(payload: CreatePayloadTest): ModelTest {
                throw NotImplementedError()
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
            repository.get(1, Unit)
        )
    }

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

    @Test
    fun testUpdate() = runBlocking {
        val repository = object : IModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override suspend fun get(id: Long): ModelTest? {
                throw NotImplementedError()
            }

            override suspend fun create(payload: CreatePayloadTest): ModelTest {
                throw NotImplementedError()
            }

            override suspend fun update(id: Long, payload: UpdatePayloadTest): Boolean {
                return true
            }

            override suspend fun delete(id: Long): Boolean {
                throw NotImplementedError()
            }
        }
        assertEquals(
            true,
            repository.update(1, UpdatePayloadTest("test"), Unit)
        )
    }

    @Test
    fun testDelete() = runBlocking {
        val repository = object : IModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override suspend fun get(id: Long): ModelTest? {
                throw NotImplementedError()
            }

            override suspend fun create(payload: CreatePayloadTest): ModelTest {
                throw NotImplementedError()
            }

            override suspend fun update(id: Long, payload: UpdatePayloadTest): Boolean {
                throw NotImplementedError()
            }

            override suspend fun delete(id: Long): Boolean {
                return true
            }
        }
        assertEquals(
            true,
            repository.delete(1, Unit)
        )
    }

}