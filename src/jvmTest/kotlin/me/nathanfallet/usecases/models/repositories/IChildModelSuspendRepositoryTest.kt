package me.nathanfallet.usecases.models.repositories

import kotlinx.coroutines.runBlocking
import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import kotlin.test.Test
import kotlin.test.assertFailsWith

class IChildModelSuspendRepositoryTest {

    @Test
    fun testListUnsupported(): Unit = runBlocking {
        val repository =
            object : IChildModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest, Unit> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.list(Unit)
        }
    }

    @Test
    fun testListLimitOffsetUnsupported(): Unit = runBlocking {
        val repository =
            object : IChildModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest, Unit> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.list(1, 0, Unit)
        }
    }

    @Test
    fun testGetUnsupported(): Unit = runBlocking {
        val repository =
            object : IChildModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest, Unit> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.get(1, Unit)
        }
    }

    @Test
    fun testCreateUnsupported(): Unit = runBlocking {
        val repository =
            object : IChildModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest, Unit> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.create(CreatePayloadTest("test"), Unit)
        }
    }

    @Test
    fun testUpdateUnsupported(): Unit = runBlocking {
        val repository =
            object : IChildModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest, Unit> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.update(1, UpdatePayloadTest("test"), Unit)
        }
    }

    @Test
    fun testDeleteUnsupported(): Unit = runBlocking {
        val repository =
            object : IChildModelSuspendRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest, Unit> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.delete(1, Unit)
        }
    }

}
