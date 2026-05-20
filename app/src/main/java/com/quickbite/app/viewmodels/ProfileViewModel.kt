package com.quickbite.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quickbite.app.data.models.User
import javax.inject.Inject

class ProfileViewModel @Inject constructor() : ViewModel() {

    private val _user = MutableLiveData<User?>()
    val user: LiveData<User?> = _user

    fun loadUser() {
        _user.value = User(
            email = "user@quickbite.com",
            displayName = "QuickBite User",
            isLoggedIn = true
        )
    }

    fun logout() {
        _user.value = null
    }
}