package com.quickbite.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quickbite.app.data.models.User
import com.quickbite.app.data.repository.AuthRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> = _user

    fun loadUser() {
        viewModelScope.launch {
            _user.value = authRepository.fetchUserProfile()
        }
    }

    fun logout() {
        authRepository.logout()
        _user.value = null
    }
}
