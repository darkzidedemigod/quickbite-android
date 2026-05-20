package com.quickbite.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quickbite.app.data.models.User
import com.quickbite.app.data.wrapper.Resource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class LoginViewModel @Inject constructor() : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _loginState = MutableLiveData<Resource<User>>()
    val loginState: LiveData<Resource<User>> = _loginState

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

        disposables.add(
            mockAuthentication(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ user ->
                    _loginState.value = Resource.success(user)
                }, { error ->
                    _loginState.value = Resource.error(
                        error.localizedMessage ?: "Invalid email or password"
                    )
                })
        )
    }

    private fun mockAuthentication(email: String, password: String): Single<User> {
        return Single.fromCallable {
            Thread.sleep(1500)
            if (email.isNotBlank() && password.length >= 6) {
                val displayName = email.substringBefore("@")
                    .replace(".", " ")
                    .replaceFirstChar { it.uppercase() }
                User(
                    email = email,
                    displayName = displayName,
                    isLoggedIn = true
                )
            } else {
                throw IllegalArgumentException("Invalid credentials")
            }
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

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}