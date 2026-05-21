package com.quickbite.app.di

import android.app.Application
import com.quickbite.app.data.remote.ApiService
import com.quickbite.app.data.repository.AuthRepository
import com.quickbite.app.data.repository.MealRepository
import com.quickbite.app.ui.detail.MealDetailFragment
import com.quickbite.app.ui.favorites.FavoritesFragment
import com.quickbite.app.ui.home.HomeFragment
import com.quickbite.app.ui.login.LoginActivity
import com.quickbite.app.ui.main.MainActivity
import com.quickbite.app.ui.profile.ProfileFragment
import com.quickbite.app.ui.register.RegisterActivity
import com.quickbite.app.viewmodels.FavoritesViewModel
import com.quickbite.app.viewmodels.HomeViewModel
import com.quickbite.app.viewmodels.LoginViewModel
import com.quickbite.app.viewmodels.MealDetailViewModel
import com.quickbite.app.viewmodels.ProfileViewModel
import com.quickbite.app.viewmodels.RegisterViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, AppModule::class, FirebaseModule::class])
interface AppComponent {

    fun inject(loginActivity: LoginActivity)
    fun inject(registerActivity: RegisterActivity)
    fun inject(mainActivity: MainActivity)
    fun inject(homeFragment: HomeFragment)
    fun inject(mealDetailFragment: MealDetailFragment)
    fun inject(favoritesFragment: FavoritesFragment)
    fun inject(profileFragment: ProfileFragment)

    fun getApiService(): ApiService
    fun getMealRepository(): MealRepository
    fun getAuthRepository(): AuthRepository
    fun getApplication(): Application

    fun inject(viewModel: LoginViewModel)
    fun inject(viewModel: RegisterViewModel)
    fun inject(viewModel: HomeViewModel)
    fun inject(viewModel: MealDetailViewModel)
    fun inject(viewModel: FavoritesViewModel)
    fun inject(viewModel: ProfileViewModel)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}