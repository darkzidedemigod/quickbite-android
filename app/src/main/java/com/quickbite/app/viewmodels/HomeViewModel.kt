package com.quickbite.app.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quickbite.app.data.models.Category
import com.quickbite.app.data.models.Meal
import com.quickbite.app.data.repository.MealRepository
import com.quickbite.app.data.wrapper.Resource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: MealRepository
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _categoriesState = MutableLiveData<Resource<List<Category>>>()
    val categoriesState: LiveData<Resource<List<Category>>> = _categoriesState

    private val _searchResults = MutableLiveData<Resource<List<Meal>>>()
    val searchResults: LiveData<Resource<List<Meal>>> = _searchResults

    private val _featuredMeals = MutableLiveData<Resource<List<Meal>>>()
    val featuredMeals: LiveData<Resource<List<Meal>>> = _featuredMeals

    private val _searchQuery = MutableLiveData<String>()

    init {
        loadCategories()
        loadFeaturedMeals()
    }

    fun loadCategories() {
        _categoriesState.value = Resource.loading()

        disposables.add(
            repository.fetchCategories()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { resource ->
                    _categoriesState.value = resource
                }
        )
    }

    fun loadFeaturedMeals() {
        _featuredMeals.value = Resource.loading()

        disposables.add(
            repository.searchMeals("chicken")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { resource ->
                    _featuredMeals.value = resource
                }
        )
    }

    fun searchMeals(query: String) {
        if (query.isBlank()) {
            _searchResults.value = Resource.success(emptyList())
            loadFeaturedMeals()
            return
        }

        _searchResults.value = Resource.loading()

        disposables.add(
            repository.searchMeals(query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { resource ->
                    _searchResults.value = resource
                }
        )
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}