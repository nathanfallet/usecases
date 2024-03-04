package me.nathanfallet.usecases.models.repositories.remote

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.UnitModel
import me.nathanfallet.usecases.models.id.RecursiveId
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import me.nathanfallet.usecases.pagination.Pagination
import kotlin.test.Test
import kotlin.test.assertFailsWith

class IChildModelRemoteRepositoryTest {

    @Test
    fun testListUnsupported(): Unit = runBlocking {
        val repository =
            object : IChildModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest, Unit> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.list(RecursiveId<UnitModel, Unit, Unit>(Unit))
        }
    }

    @Test
    fun testListLimitOffsetUnsupported(): Unit = runBlocking {
        val repository =
            object : IChildModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest, Unit> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.list(Pagination(1, 0), RecursiveId<UnitModel, Unit, Unit>(Unit))
        }
    }

    @Test
    fun testCountUnsupported(): Unit = runBlocking {
        val repository =
            object : IChildModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest, Unit> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.count(RecursiveId<UnitModel, Unit, Unit>(Unit))
        }
    }

    @Test
    fun testGetUnsupported(): Unit = runBlocking {
        val repository =
            object : IChildModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest, Unit> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.get(1, RecursiveId<UnitModel, Unit, Unit>(Unit))
        }
    }

    @Test
    fun testCreateUnsupported(): Unit = runBlocking {
        val repository =
            object : IChildModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest, Unit> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.create(CreatePayloadTest("test"), RecursiveId<UnitModel, Unit, Unit>(Unit))
        }
    }

    @Test
    fun testUpdateUnsupported(): Unit = runBlocking {
        val repository =
            object : IChildModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest, Unit> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.update(1, UpdatePayloadTest("test"), RecursiveId<UnitModel, Unit, Unit>(Unit))
        }
    }

    @Test
    fun testDeleteUnsupported(): Unit = runBlocking {
        val repository =
            object : IChildModelRemoteRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest, Unit> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.delete(1, RecursiveId<UnitModel, Unit, Unit>(Unit))
        }
    }

}
