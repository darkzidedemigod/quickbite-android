package com.quickbite.app.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.quickbite.app.data.repository.MealRepository
import com.quickbite.app.data.remote.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("quickbite_prefs", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideMealRepository(apiService: ApiService, prefs: SharedPreferences): MealRepository {
        return MealRepository(apiService, prefs)
    }
}