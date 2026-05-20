package com.quickbite.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quickbite.app.data.models.Meal
import com.quickbite.app.data.repository.MealRepository
import com.quickbite.app.data.wrapper.Resource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class MealDetailViewModel @Inject constructor(
    private val repository: MealRepository
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _mealState = MutableLiveData<Resource<Meal>>()
    val mealState: LiveData<Resource<Meal>> = _mealState

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> = _isFavorite

    fun loadMeal(mealId: String) {
        _mealState.value = Resource.loading()

        disposables.add(
            repository.getMealById(mealId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { resource ->
                    _mealState.value = resource
                    if (resource is Resource.Success) {
                        _isFavorite.value = repository.isFavorite(resource.data.idMeal)
                    }
                }
        )
    }

    fun toggleFavorite(meal: Meal) {
        val isNowFavorite = repository.toggleFavorite(meal)
        _isFavorite.value = isNowFavorite
    }

    fun loadFavoriteStatus(mealId: String) {
        _isFavorite.value = repository.isFavorite(mealId)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}