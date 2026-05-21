package com.quickbite.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quickbite.app.data.repository.AuthRepository
import com.quickbite.app.data.wrapper.Resource
import com.quickbite.app.ui.register.RegisterState
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegisterViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _registerState = MutableLiveData<RegisterState>(RegisterState.Idle)
    val registerState: LiveData<RegisterState> = _registerState

    private val _firstNameError = MutableLiveData<String?>(null)
    val firstNameError: LiveData<String?> = _firstNameError

    private val _lastNameError = MutableLiveData<String?>(null)
    val lastNameError: LiveData<String?> = _lastNameError

    private val _emailError = MutableLiveData<String?>(null)
    val emailError: LiveData<String?> = _emailError

    private val _passwordError = MutableLiveData<String?>(null)
    val passwordError: LiveData<String?> = _passwordError

    private val _confirmPasswordError = MutableLiveData<String?>(null)
    val confirmPasswordError: LiveData<String?> = _confirmPasswordError

    private val _isFormValid = MutableLiveData<Boolean>(false)
    val isFormValid: LiveData<Boolean> = _isFormValid

    fun onFieldsChanged(
        firstName: String,
        lastName: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {
        val isFirstNameValid = firstName.length >= 2
        val isLastNameValid = lastName.length >= 2
        val isEmailValid = isValidEmail(email)
        val isPasswordValid = isPasswordValid(password)
        val isConfirmValid = password == confirmPassword && confirmPassword.isNotEmpty()

        // Provide feedback as user types if they have entered something
        _firstNameError.value = if (firstName.isNotEmpty() && !isFirstNameValid) "Min 2 characters" else null
        _lastNameError.value = if (lastName.isNotEmpty() && !isLastNameValid) "Min 2 characters" else null
        _emailError.value = if (email.isNotEmpty() && !isEmailValid) "Invalid email format" else null
        _passwordError.value = if (password.isNotEmpty() && !isPasswordValid) "Need 8+ chars, 1 Upper, 1 Lower, 1 Number" else null
        _confirmPasswordError.value = if (confirmPassword.isNotEmpty() && !isConfirmValid) "Passwords do not match" else null

        _isFormValid.value = isFirstNameValid && 
                           isLastNameValid && 
                           isEmailValid && 
                           isPasswordValid && 
                           isConfirmValid
    }

    fun register(
        firstName: String,
        lastName: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {
        if (!validateForm(firstName, lastName, email, password, confirmPassword)) {
            return
        }

        _registerState.value = RegisterState.Loading

        viewModelScope.launch {
            val result = authRepository.registerUser(firstName, lastName, email, password)
            when (result) {
                is Resource.Success -> _registerState.value = RegisterState.Success
                is Resource.Error -> _registerState.value = RegisterState.Error(result.message)
                else -> _registerState.value = RegisterState.Idle
            }
        }
    }

    private fun validateForm(
        firstName: String,
        lastName: String,
        email: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        var isValid = true

        if (firstName.isBlank() || firstName.length < 2) {
            _firstNameError.value = "First name must be at least 2 characters"
            isValid = false
        } else {
            _firstNameError.value = null
        }

        if (lastName.isBlank() || lastName.length < 2) {
            _lastNameError.value = "Last name must be at least 2 characters"
            isValid = false
        } else {
            _lastNameError.value = null
        }

        if (!isValidEmail(email)) {
            _emailError.value = "Invalid email format"
            isValid = false
        } else {
            _emailError.value = null
        }

        if (!isPasswordValid(password)) {
            _passwordError.value = "Password must be at least 8 characters, with 1 uppercase, 1 lowercase, and 1 number"
            isValid = false
        } else {
            _passwordError.value = null
        }

        if (password != confirmPassword) {
            _confirmPasswordError.value = "Passwords do not match"
            isValid = false
        } else {
            _confirmPasswordError.value = null
        }

        return isValid
    }

    private fun isValidEmail(email: String): Boolean {
        // Updated regex to support modern TLDs with more than 6 characters
        val emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
        return email.matches(emailRegex.toRegex())
    }

    private fun isPasswordValid(password: String): Boolean {
        val passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$"
        return password.matches(passwordPattern.toRegex())
    }
}