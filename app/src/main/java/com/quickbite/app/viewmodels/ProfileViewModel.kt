package com.quickbite.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quickbite.app.data.models.User
import com.quickbite.app.data.repository.AuthRepository
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> = _user

    fun loadUser() {
        _user.value = authRepository.getCurrentUser()
    }

    fun logout() {
        authRepository.logout()
        _user.value = null
    }
}
