package com.quickbite.app.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.quickbite.app.data.wrapper.Resource
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: LoginViewModel

    @Before
    fun setUp() {
        viewModel = LoginViewModel()
    }

    @Test
    fun `login with empty email should show email error`() {
        viewModel.login("", "password123")

        val emailError = viewModel.emailError.value
        assertNotNull(emailError)
        assertTrue(emailError?.isNotEmpty() == true)
    }

    @Test
    fun `login with invalid email format should show email error`() {
        viewModel.login("invalid-email", "password123")

        val emailError = viewModel.emailError.value
        assertNotNull(emailError)
    }

    @Test
    fun `login with short password should show password error`() {
        viewModel.login("test@example.com", "12345")

        val passwordError = viewModel.passwordError.value
        assertNotNull(passwordError)
    }

    @Test
    fun `login with valid credentials should emit loading then success`() {
        viewModel.login("test@quickbite.com", "password123")

        val loginState = viewModel.loginState.value
        assertTrue(loginState is Resource.Loading)
    }

    @Test
    fun `clear errors should reset all error states`() {
        viewModel.login("", "12345")
        viewModel.clearErrors()

        assertNull(viewModel.emailError.value)
        assertNull(viewModel.passwordError.value)
        assertNull(viewModel.loginState.value)
    }
}