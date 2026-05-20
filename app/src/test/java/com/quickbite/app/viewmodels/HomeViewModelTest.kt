package com.quickbite.app.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.quickbite.app.data.models.Category
import com.quickbite.app.data.models.Meal
import com.quickbite.app.data.remote.ApiService
import com.quickbite.app.data.repository.MealRepository
import com.quickbite.app.data.wrapper.Resource
import io.reactivex.rxjava3.core.Single
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class HomeViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var apiService: ApiService

    private lateinit var repository: MealRepository
    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        val prefs = mock(android.content.SharedPreferences::class.java)
        repository = MealRepository(apiService, prefs)
    }

    @Test
    fun `loadCategories should emit success with categories`() {
        val categories = listOf(
            Category("1", "Chicken", "https://example.com/chicken.jpg", "Chicken dishes"),
            Category("2", "Beef", "https://example.com/beef.jpg", "Beef dishes")
        )
        `when`(apiService.getCategories()).thenReturn(
            Single.just(com.quickbite.app.data.models.CategoryResponse(categories))
        )

        viewModel = HomeViewModel(repository)
        val state = viewModel.categoriesState.value

        assertTrue(state is Resource.Success)
        assertEquals(2, (state as Resource.Success).data.size)
    }

    @Test
    fun `loadCategories should emit error on failure`() {
        `when`(apiService.getCategories()).thenReturn(
            Single.error(RuntimeException("Network error"))
        )

        viewModel = HomeViewModel(repository)
        val state = viewModel.categoriesState.value

        assertTrue(state is Resource.Error)
    }

    @Test
    fun `searchMeals with empty query should show empty results`() {
        viewModel = HomeViewModel(repository)
        viewModel.searchMeals("")

        val state = viewModel.searchResults.value
        assertTrue(state is Resource.Success)
        assertTrue((state as Resource.Success).data.isEmpty())
    }

    @Test
    fun `searchMeals should return meals for valid query`() {
        val meals = listOf(
            Meal(idMeal = "1", strMeal = "Chicken Curry", strCategory = "Chicken")
        )
        `when`(apiService.searchMeals("chicken")).thenReturn(
            Single.just(com.quickbite.app.data.models.MealResponse(meals))
        )

        viewModel = HomeViewModel(repository)
        viewModel.searchMeals("chicken")

        val state = viewModel.searchResults.value
        assertTrue(state is Resource.Success)
    }
}