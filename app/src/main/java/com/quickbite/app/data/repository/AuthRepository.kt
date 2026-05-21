package com.quickbite.app.data.repository

import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.firestore.FirebaseFirestore
import com.quickbite.app.data.models.User
import com.quickbite.app.data.models.UserRegistration
import com.quickbite.app.data.wrapper.Resource
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

interface AuthRepository {
    suspend fun registerUser(
        firstName: String,
        lastName: String,
        email: String,
        password: String
    ): Resource<Unit>

    suspend fun loginUser(email: String, password: String): Resource<User>
    
    fun getCurrentUser(): User?
    
    fun logout()
}

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : AuthRepository {

    override suspend fun registerUser(
        firstName: String,
        lastName: String,
        email: String,
        password: String
    ): Resource<Unit> {
        return try {
            val authResult = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            val userId = authResult.user?.uid ?: return Resource.error("User ID is null")

            val userRegistration = UserRegistration(
                firstName = firstName,
                lastName = lastName,
                email = email
            )

            firestore.collection("users")
                .document(userId)
                .set(userRegistration)
                .await()

            Resource.success(Unit)
        } catch (e: FirebaseAuthUserCollisionException) {
            Resource.error("This email is already registered")
        } catch (e: FirebaseAuthWeakPasswordException) {
            Resource.error("The password is too weak")
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            Resource.error("Invalid email format")
        } catch (e: FirebaseNetworkException) {
            Resource.error("Network failure. Please check your connection")
        } catch (e: Exception) {
            Resource.error(e.localizedMessage ?: "An unknown error occurred", e)
        }
    }

    override suspend fun loginUser(email: String, password: String): Resource<User> {
        return try {
            val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            val firebaseUser = authResult.user ?: return Resource.error("User not found")
            
            val user = User(
                email = firebaseUser.email ?: email,
                displayName = firebaseUser.displayName ?: email.substringBefore("@"),
                isLoggedIn = true
            )
            Resource.success(user)
        } catch (e: FirebaseAuthInvalidUserException) {
            Resource.error("No account found with this email")
        } catch (e: FirebaseAuthInvalidCredentialsException) {
            Resource.error("Invalid email or password")
        } catch (e: FirebaseNetworkException) {
            Resource.error("Network failure. Please check your connection")
        } catch (e: Exception) {
            Resource.error(e.localizedMessage ?: "Login failed", e)
        }
    }

    override fun getCurrentUser(): User? {
        return firebaseAuth.currentUser?.let {
            User(
                email = it.email ?: "",
                displayName = it.displayName ?: "",
                isLoggedIn = true
            )
        }
    }

    override fun logout() {
        firebaseAuth.signOut()
    }
}
