package com.quickbite.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quickbite.app.data.models.Meal
import com.quickbite.app.data.repository.MealRepository
import com.quickbite.app.data.wrapper.Resource
import javax.inject.Inject

class FavoritesViewModel @Inject constructor(
    private val repository: MealRepository
) : ViewModel() {

    private val _favoritesState = MutableLiveData<Resource<List<Meal>>>()
    val favoritesState: LiveData<Resource<List<Meal>>> = _favoritesState

    fun loadFavorites() {
        val favorites = repository.getFavorites()
        _favoritesState.value = if (favorites.isEmpty()) {
            Resource.success(emptyList())
        } else {
            Resource.success(favorites)
        }
    }

    fun removeFavorite(mealId: String) {
        repository.removeFavorite(mealId)
        loadFavorites()
    }
}