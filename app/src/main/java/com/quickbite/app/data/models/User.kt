package com.quickbite.app.data.models

data class User(
    val email: String,
    val displayName: String,
    val firstName: String = "",
    val lastName: String = "",
    val isLoggedIn: Boolean = false
)
