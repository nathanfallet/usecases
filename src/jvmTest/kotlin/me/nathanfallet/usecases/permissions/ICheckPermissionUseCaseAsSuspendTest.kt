package me.nathanfallet.usecases.permissions

import io.mockative.*
import kotlinx.coroutines.runBlocking
import kotlin.test.AfterTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ICheckPermissionUseCaseAsSuspendTest {

    @Mock
    val useCase = mock(classOf<ICheckPermissionUseCase>())

    @AfterTest
    fun after() {
        verifyNoUnmetExpectations(useCase)
    }

    @Test
    fun invokeSuspendFromNonSuspend() = runBlocking {
        val permitee = object : IPermittee {}
        val permission = object : IPermission {}
        every { useCase(permitee, permission) }.returns(true)
        val suspendUseCase = ICheckPermissionUseCaseAsSuspend(useCase)
        assertEquals(true, suspendUseCase(permitee, permission))
        coVerify {
            useCase(permitee, permission)
        }.wasInvoked()
    }

}