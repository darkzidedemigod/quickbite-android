package com.quickbite.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quickbite.app.data.models.User
import com.quickbite.app.data.repository.AuthRepository
import com.quickbite.app.data.wrapper.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _loginState = MutableLiveData<Resource<User>?>()
    val loginState: LiveData<Resource<User>?> = _loginState

    private val _emailError = MutableLiveData<String?>()
    val emailError: LiveData<String?> = _emailError

    private val _passwordError = MutableLiveData<String?>()
    val passwordError: LiveData<String?> = _passwordError

    fun login(email: String, password: String) {
        _emailError.value = null
        _passwordError.value = null

        var hasError = false

        if (!isValidEmail(email)) {
            _emailError.value = "Please enter a valid email"
            hasError = true
        }

        if (!isValidPassword(password)) {
            _passwordError.value = "Password must be at least 6 characters"
            hasError = true
        }

        if (hasError) return

        _loginState.value = Resource.loading()

        viewModelScope.launch {
            val result = authRepository.loginUser(email, password)
            _loginState.value = result
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        return password.length >= 6
    }

    fun clearErrors() {
        _emailError.value = null
        _passwordError.value = null
        _loginState.value = null
    }
}
