package com.quickbite.app.data.repository

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.quickbite.app.data.models.Category
import com.quickbite.app.data.models.Meal
import com.quickbite.app.data.remote.ApiService
import com.quickbite.app.data.wrapper.Resource
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MealRepository @Inject constructor(
    private val apiService: ApiService,
    private val prefs: SharedPreferences
) {
    private val gson = Gson()
    private val favoritesKey = "favorites"

    fun fetchCategories(): Single<Resource<List<Category>>> {
        return apiService.getCategories()
            .map { response ->
                val categories = response.categories ?: emptyList()
                if (categories.isEmpty()) {
                    Resource.error("No categories found")
                } else {
                    Resource.success(categories)
                }
            }
            .onErrorReturn { error ->
                Resource.error(
                    error.localizedMessage ?: "Failed to load categories",
                    error
                )
            }
            .subscribeOn(Schedulers.io())
    }

    fun searchMeals(query: String): Single<Resource<List<Meal>>> {
        return apiService.searchMeals(query)
            .map { response ->
                val meals = response.meals ?: emptyList()
                if (meals.isEmpty()) {
                    Resource.success(emptyList())
                } else {
                    Resource.success(meals)
                }
            }
            .onErrorReturn { error ->
                Resource.error(
                    error.localizedMessage ?: "Failed to search meals",
                    error
                )
            }
            .subscribeOn(Schedulers.io())
    }

    fun getMealById(id: String): Single<Resource<Meal>> {
        return apiService.searchMeals(id)
            .map { response ->
                val meal = response.meals?.firstOrNull()
                if (meal != null) {
                    Resource.success(meal)
                } else {
                    Resource.error("Meal not found")
                }
            }
            .onErrorReturn { error ->
                Resource.error(
                    error.localizedMessage ?: "Failed to load meal details",
                    error
                )
            }
            .subscribeOn(Schedulers.io())
    }

    fun getFavorites(): List<Meal> {
        val json = prefs.getString(favoritesKey, null) ?: return emptyList()
        val type = object : TypeToken<List<Meal>>() {}.type
        return gson.fromJson(json, type) ?: emptyList()
    }

    fun isFavorite(mealId: String): Boolean {
        return getFavorites().any { it.idMeal == mealId }
    }

    fun toggleFavorite(meal: Meal): Boolean {
        val favorites = getFavorites().toMutableList()
        return if (favorites.any { it.idMeal == meal.idMeal }) {
            favorites.removeAll { it.idMeal == meal.idMeal }
            saveFavorites(favorites)
            false
        } else {
            favorites.add(meal)
            saveFavorites(favorites)
            true
        }
    }

    fun removeFavorite(mealId: String) {
        val favorites = getFavorites().toMutableList()
        favorites.removeAll { it.idMeal == mealId }
        saveFavorites(favorites)
    }

    private fun saveFavorites(favorites: List<Meal>) {
        val json = gson.toJson(favorites)
        prefs.edit().putString(favoritesKey, json).apply()
    }
}