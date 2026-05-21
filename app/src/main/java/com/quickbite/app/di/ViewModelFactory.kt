package com.quickbite.app.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.quickbite.app.data.repository.AuthRepository
import com.quickbite.app.data.repository.MealRepository
import com.quickbite.app.viewmodels.FavoritesViewModel
import com.quickbite.app.viewmodels.HomeViewModel
import com.quickbite.app.viewmodels.LoginViewModel
import com.quickbite.app.viewmodels.MealDetailViewModel
import com.quickbite.app.viewmodels.ProfileViewModel
import com.quickbite.app.viewmodels.RegisterViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val mealRepository: MealRepository,
    private val authRepository: AuthRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) ->
                HomeViewModel(mealRepository) as T
            modelClass.isAssignableFrom(MealDetailViewModel::class.java) ->
                MealDetailViewModel(mealRepository) as T
            modelClass.isAssignableFrom(FavoritesViewModel::class.java) ->
                FavoritesViewModel(mealRepository) as T
            modelClass.isAssignableFrom(ProfileViewModel::class.java) ->
                ProfileViewModel(authRepository) as T
            modelClass.isAssignableFrom(LoginViewModel::class.java) ->
                LoginViewModel(authRepository) as T
            modelClass.isAssignableFrom(RegisterViewModel::class.java) ->
                RegisterViewModel(authRepository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}
