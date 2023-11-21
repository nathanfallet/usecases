package me.nathanfallet.usecases.models.repositories

import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import kotlin.test.Test
import kotlin.test.assertEquals

class IModelRepositoryTest {

    @Test
    fun testList() {
        val repository = object : IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override fun list(): List<ModelTest> {
                return listOf(ModelTest(1, "test"))
            }

            override fun list(limit: Long, offset: Long): List<ModelTest> {
                throw NotImplementedError()
            }

            override fun get(id: Long): ModelTest {
                throw NotImplementedError()
            }

            override fun create(payload: CreatePayloadTest): ModelTest {
                throw NotImplementedError()
            }

            override fun update(id: Long, payload: UpdatePayloadTest): Boolean {
                throw NotImplementedError()
            }

            override fun delete(id: Long): Boolean {
                throw NotImplementedError()
            }
        }
        assertEquals(
            listOf(ModelTest(1, "test")),
            repository.list(Unit)
        )
    }

    @Test
    fun testListLimitOffset() {
        val repository = object : IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override fun list(): List<ModelTest> {
                throw NotImplementedError()
            }

            override fun list(limit: Long, offset: Long): List<ModelTest> {
                return listOf(ModelTest(1, "test"))
            }

            override fun get(id: Long): ModelTest {
                throw NotImplementedError()
            }

            override fun create(payload: CreatePayloadTest): ModelTest {
                throw NotImplementedError()
            }

            override fun update(id: Long, payload: UpdatePayloadTest): Boolean {
                throw NotImplementedError()
            }

            override fun delete(id: Long): Boolean {
                throw NotImplementedError()
            }
        }
        assertEquals(
            listOf(ModelTest(1, "test")),
            repository.list(1, 0, Unit)
        )
    }

    @Test
    fun testGet() {
        val repository = object : IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override fun list(): List<ModelTest> {
                throw NotImplementedError()
            }

            override fun list(limit: Long, offset: Long): List<ModelTest> {
                throw NotImplementedError()
            }

            override fun get(id: Long): ModelTest {
                return ModelTest(1, "test")
            }

            override fun create(payload: CreatePayloadTest): ModelTest {
                throw NotImplementedError()
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
            repository.get(1, Unit)
        )
    }

    @Test
    fun testCreate() {
        val repository = object : IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override fun list(): List<ModelTest> {
                throw NotImplementedError()
            }

            override fun list(limit: Long, offset: Long): List<ModelTest> {
                throw NotImplementedError()
            }

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

    @Test
    fun testUpdate() {
        val repository = object : IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override fun list(): List<ModelTest> {
                throw NotImplementedError()
            }

            override fun list(limit: Long, offset: Long): List<ModelTest> {
                throw NotImplementedError()
            }

            override fun get(id: Long): ModelTest? {
                throw NotImplementedError()
            }

            override fun create(payload: CreatePayloadTest): ModelTest {
                throw NotImplementedError()
            }

            override fun update(id: Long, payload: UpdatePayloadTest): Boolean {
                return true
            }

            override fun delete(id: Long): Boolean {
                throw NotImplementedError()
            }
        }
        assertEquals(
            true,
            repository.update(1, UpdatePayloadTest("test"), Unit)
        )
    }

    @Test
    fun testDelete() {
        val repository = object : IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override fun list(): List<ModelTest> {
                throw NotImplementedError()
            }

            override fun list(limit: Long, offset: Long): List<ModelTest> {
                throw NotImplementedError()
            }

            override fun get(id: Long): ModelTest? {
                throw NotImplementedError()
            }

            override fun create(payload: CreatePayloadTest): ModelTest {
                throw NotImplementedError()
            }

            override fun update(id: Long, payload: UpdatePayloadTest): Boolean {
                throw NotImplementedError()
            }

            override fun delete(id: Long): Boolean {
                return true
            }
        }
        assertEquals(
            true,
            repository.delete(1, Unit)
        )
    }

}
