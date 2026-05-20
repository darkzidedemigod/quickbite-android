package com.quickbite.app.data.wrapper

sealed class Resource<T> {
    data class Success<T>(val data: T) : Resource<T>()
    data class Error<T>(val message: String, val exception: Throwable? = null) : Resource<T>()
    data class Loading<T>(val isLoading: Boolean = true) : Resource<T>()

    fun isLoading(): Boolean = this is Loading
    fun isSuccess(): Boolean = this is Success
    fun isError(): Boolean = this is Error

    fun getDataOrNull(): T? = when (this) {
        is Success -> data
        else -> null
    }

    fun getErrorMessage(): String? = when (this) {
        is Error -> message
        else -> null
    }

    companion object {
        fun <T> loading(): Resource<T> = Loading()
        fun <T> success(data: T): Resource<T> = Success(data)
        fun <T> error(message: String, exception: Throwable? = null): Resource<T> =
            Error(message, exception)
    }
}