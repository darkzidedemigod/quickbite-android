package com.quickbite.app.data.models

data class UserRegistration(
    val firstName: String,
    val lastName: String,
    val email: String,
    val createdAt: Long = System.currentTimeMillis()
)