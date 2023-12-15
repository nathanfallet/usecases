package me.nathanfallet.usecases.models.repositories.remote

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.context.IContext
import me.nathanfallet.usecases.models.UnitModel
import me.nathanfallet.usecases.models.id.RecursiveId
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class IModelRemoteRepositoryTest {

    @Test
    fun testList() = runBlocking {
        val repository = object : IModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override suspend fun list(context: IContext?): List<ModelTest> {
                return listOf(ModelTest(1, "test"))
            }
        }
        assertEquals(
            listOf(ModelTest(1, "test")),
            repository.list(RecursiveId<UnitModel, Unit, Unit>(Unit))
        )
    }

    @Test
    fun testListNullContext() = runBlocking {
        val repository = object : IModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override suspend fun list(context: IContext?): List<ModelTest> {
                return listOf(ModelTest(1, "test"))
            }
        }
        assertEquals(
            listOf(ModelTest(1, "test")),
            repository.list()
        )
    }

    @Test
    fun testListUnsupported(): Unit = runBlocking {
        val repository = object : IModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.list(RecursiveId<UnitModel, Unit, Unit>(Unit))
        }
    }

    @Test
    fun testListLimitOffset() = runBlocking {
        val repository = object : IModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override suspend fun list(limit: Long, offset: Long, context: IContext?): List<ModelTest> {
                return listOf(ModelTest(1, "test"))
            }
        }
        assertEquals(
            listOf(ModelTest(1, "test")),
            repository.list(1, 0, RecursiveId<UnitModel, Unit, Unit>(Unit))
        )
    }

    @Test
    fun testListLimitOffsetNullContext() = runBlocking {
        val repository = object : IModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override suspend fun list(limit: Long, offset: Long, context: IContext?): List<ModelTest> {
                return listOf(ModelTest(1, "test"))
            }
        }
        assertEquals(
            listOf(ModelTest(1, "test")),
            repository.list(1, 0)
        )
    }

    @Test
    fun testListLimitOffsetUnsupported(): Unit = runBlocking {
        val repository = object : IModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.list(1, 0, RecursiveId<UnitModel, Unit, Unit>(Unit))
        }
    }

    @Test
    fun testGet() = runBlocking {
        val repository = object : IModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override suspend fun get(id: Long, context: IContext?): ModelTest {
                return ModelTest(1, "test")
            }
        }
        assertEquals(
            ModelTest(1, "test"),
            repository.get(1, RecursiveId<UnitModel, Unit, Unit>(Unit))
        )
    }

    @Test
    fun testGetNullContext() = runBlocking {
        val repository = object : IModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override suspend fun get(id: Long, context: IContext?): ModelTest {
                return ModelTest(1, "test")
            }
        }
        assertEquals(
            ModelTest(1, "test"),
            repository.get(1)
        )
    }

    @Test
    fun testGetUnsupported(): Unit = runBlocking {
        val repository = object : IModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.get(1, RecursiveId<UnitModel, Unit, Unit>(Unit))
        }
    }

    @Test
    fun testCreate() = runBlocking {
        val repository = object : IModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override suspend fun create(payload: CreatePayloadTest, context: IContext?): ModelTest {
                return ModelTest(1, payload.value)
            }
        }
        assertEquals(
            ModelTest(1, "test"),
            repository.create(CreatePayloadTest("test"), RecursiveId<UnitModel, Unit, Unit>(Unit))
        )
    }

    @Test
    fun testCreateNullContext() = runBlocking {
        val repository = object : IModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override suspend fun create(payload: CreatePayloadTest, context: IContext?): ModelTest {
                return ModelTest(1, payload.value)
            }
        }
        assertEquals(
            ModelTest(1, "test"),
            repository.create(CreatePayloadTest("test"))
        )
    }

    @Test
    fun testCreateUnsupported(): Unit = runBlocking {
        val repository = object : IModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.create(CreatePayloadTest("test"), RecursiveId<UnitModel, Unit, Unit>(Unit))
        }
    }

    @Test
    fun testUpdate() = runBlocking {
        val repository = object : IModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override suspend fun update(id: Long, payload: UpdatePayloadTest, context: IContext?): ModelTest? {
                return ModelTest(1, payload.value)
            }
        }
        assertEquals(
            ModelTest(1, "test"),
            repository.update(1, UpdatePayloadTest("test"), RecursiveId<UnitModel, Unit, Unit>(Unit))
        )
    }

    @Test
    fun testUpdateNullContext() = runBlocking {
        val repository = object : IModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override suspend fun update(id: Long, payload: UpdatePayloadTest, context: IContext?): ModelTest? {
                return ModelTest(1, payload.value)
            }
        }
        assertEquals(
            ModelTest(1, "test"),
            repository.update(1, UpdatePayloadTest("test"))
        )
    }

    @Test
    fun testUpdateUnsupported(): Unit = runBlocking {
        val repository = object : IModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.update(1, UpdatePayloadTest("test"), RecursiveId<UnitModel, Unit, Unit>(Unit))
        }
    }

    @Test
    fun testDelete() = runBlocking {
        val repository = object : IModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override suspend fun delete(id: Long, context: IContext?): Boolean {
                return true
            }
        }
        assertEquals(
            true,
            repository.delete(1, RecursiveId<UnitModel, Unit, Unit>(Unit))
        )
    }

    @Test
    fun testDeleteNullContext() = runBlocking {
        val repository = object : IModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {
            override suspend fun delete(id: Long, context: IContext?): Boolean {
                return true
            }
        }
        assertEquals(
            true,
            repository.delete(1)
        )
    }

    @Test
    fun testDeleteUnsupported(): Unit = runBlocking {
        val repository = object : IModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.delete(1, RecursiveId<UnitModel, Unit, Unit>(Unit))
        }
    }

}
