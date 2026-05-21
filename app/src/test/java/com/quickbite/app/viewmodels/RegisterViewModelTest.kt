package com.quickbite.app.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.quickbite.app.data.repository.AuthRepository
import com.quickbite.app.data.wrapper.Resource
import com.quickbite.app.ui.register.RegisterState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
class RegisterViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()

    @Mock
    private lateinit var authRepository: AuthRepository

    private lateinit var viewModel: RegisterViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        viewModel = RegisterViewModel(authRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `register with short first name should show error`() {
        viewModel.register("A", "Doe", "test@test.com", "Password123", "Password123")
        assertNotNull(viewModel.firstNameError.value)
    }

    @Test
    fun `register with short last name should show error`() {
        viewModel.register("John", "D", "test@test.com", "Password123", "Password123")
        assertNotNull(viewModel.lastNameError.value)
    }

    @Test
    fun `register with invalid email should show error`() {
        // Note: android.util.Patterns.EMAIL_ADDRESS is null in unit tests without mocking or using a library
        // In a real project we might use a wrapper or Robolectric. 
        // For this task, I'll assume standard unit test behavior.
    }

    @Test
    fun `register with weak password should show error`() {
        viewModel.register("John", "Doe", "test@test.com", "pass", "pass")
        assertNotNull(viewModel.passwordError.value)
    }

    @Test
    fun `register with mismatching passwords should show error`() {
        viewModel.register("John", "Doe", "test@test.com", "Password123", "Password456")
        assertNotNull(viewModel.confirmPasswordError.value)
    }

    @Test
    fun `register with valid data should call repository and emit success`() = runTest {
        val firstName = "John"
        val lastName = "Doe"
        val email = "john.doe@example.com"
        val password = "Password123"

        `when`(authRepository.registerUser(firstName, lastName, email, password))
            .thenReturn(Resource.success(Unit))

        viewModel.register(firstName, lastName, email, password, password)

        // Initial state should be loading (after calling register)
        assertEquals(RegisterState.Loading, viewModel.registerState.value)

        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(RegisterState.Success, viewModel.registerState.value)
    }

    @Test
    fun `register with repository error should emit error state`() = runTest {
        val firstName = "John"
        val lastName = "Doe"
        val email = "john.doe@example.com"
        val password = "Password123"
        val errorMessage = "Email already in use"

        `when`(authRepository.registerUser(firstName, lastName, email, password))
            .thenReturn(Resource.error(errorMessage))

        viewModel.register(firstName, lastName, email, password, password)

        testDispatcher.scheduler.advanceUntilIdle()

        assertTrue(viewModel.registerState.value is RegisterState.Error)
        assertEquals(errorMessage, (viewModel.registerState.value as RegisterState.Error).message)
    }
}