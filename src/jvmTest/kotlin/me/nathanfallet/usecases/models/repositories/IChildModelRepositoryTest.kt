package me.nathanfallet.usecases.models.repositories

import me.nathanfallet.usecases.models.mock.CreatePayloadTest
import me.nathanfallet.usecases.models.mock.ModelTest
import me.nathanfallet.usecases.models.mock.UpdatePayloadTest
import kotlin.test.Test
import kotlin.test.assertFailsWith

class IChildModelRepositoryTest {

    @Test
    fun testListUnsupported() {
        val repository = object : IChildModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest, Unit> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.list(Unit)
        }
    }

    @Test
    fun testListLimitOffsetUnsupported() {
        val repository = object : IChildModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest, Unit> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.list(1, 0, Unit)
        }
    }

    @Test
    fun testGetUnsupported() {
        val repository = object : IChildModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest, Unit> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.get(1, Unit)
        }
    }

    @Test
    fun testCreateUnsupported() {
        val repository = object : IChildModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest, Unit> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.create(CreatePayloadTest("test"), Unit)
        }
    }

    @Test
    fun testUpdateUnsupported() {
        val repository = object : IChildModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest, Unit> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.update(1, UpdatePayloadTest("test"), Unit)
        }
    }

    @Test
    fun testDeleteUnsupported() {
        val repository = object : IChildModelRepository<ModelTest, Long, CreatePayloadTest, UpdatePayloadTest, Unit> {}
        assertFailsWith(UnsupportedOperationException::class) {
            repository.delete(1, Unit)
        }
    }

}
