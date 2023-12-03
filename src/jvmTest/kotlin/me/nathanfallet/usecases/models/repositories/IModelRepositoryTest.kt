package me.nathanfallet.usecases.models.repositories

import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class IModelRepositoryTest {

    @Test
    fun testList() {
        val repository = object : IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override fun list(context: IContext?): List<ModelTest> {
                return listOf(ModelTest(1, "test"))
            }
        }
        assertEquals(
            listOf(ModelTest(1, "test")),
            repository.list(Unit)
        )
    }

    @Test
    fun testListUnsupported() {
        val repository = object : IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.list(Unit)
        }
    }

    @Test
    fun testListLimitOffset() {
        val repository = object : IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override fun list(limit: Long, offset: Long, context: IContext?): List<ModelTest> {
                return listOf(ModelTest(1, "test"))
            }
        }
        assertEquals(
            listOf(ModelTest(1, "test")),
            repository.list(1, 0, Unit)
        )
    }

    @Test
    fun testListLimitOffsetUnsupported() {
        val repository = object : IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.list(1, 0, Unit)
        }
    }

    @Test
    fun testGet() {
        val repository = object : IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override fun get(id: Long, context: IContext?): ModelTest {
                return ModelTest(1, "test")
            }
        }
        assertEquals(
            ModelTest(1, "test"),
            repository.get(1, Unit)
        )
    }

    @Test
    fun testGetUnsupported() {
        val repository = object : IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.get(1, Unit)
        }
    }

    @Test
    fun testCreate() {
        val repository = object : IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override fun create(payload: CreatePayloadTest, context: IContext?): ModelTest {
                return ModelTest(1, payload.value)
            }
        }
        assertEquals(
            ModelTest(1, "test"),
            repository.create(CreatePayloadTest("test"), Unit)
        )
    }

    @Test
    fun testCreateUnsupported() {
        val repository = object : IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.create(CreatePayloadTest("test"), Unit)
        }
    }

    @Test
    fun testUpdate() {
        val repository = object : IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override fun update(id: Long, payload: UpdatePayloadTest, context: IContext?): Boolean {
                return true
            }
        }
        assertEquals(
            true,
            repository.update(1, UpdatePayloadTest("test"), Unit)
        )
    }

    @Test
    fun testUpdateUnsupported() {
        val repository = object : IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.update(1, UpdatePayloadTest("test"), Unit)
        }
    }

    @Test
    fun testDelete() {
        val repository = object : IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override fun delete(id: Long, context: IContext?): Boolean {
                return true
            }
        }
        assertEquals(
            true,
            repository.delete(1, Unit)
        )
    }

    @Test
    fun testDeleteUnsupported() {
        val repository = object : IModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.delete(1, Unit)
        }
    }

}
