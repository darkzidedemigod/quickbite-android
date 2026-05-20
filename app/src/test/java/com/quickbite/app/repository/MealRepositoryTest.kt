package com.quickbite.app.repository

import android.content.SharedPreferences
import com.quickbite.app.data.models.Category
import com.quickbite.app.data.models.Meal
import com.quickbite.app.data.remote.ApiService
import com.quickbite.app.data.repository.MealRepository
import com.quickbite.app.data.wrapper.Resource
import io.reactivex.rxjava3.core.Single
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class MealRepositoryTest {

    @Mock
    lateinit var apiService: ApiService

    @Mock
    lateinit var prefs: SharedPreferences

    @Mock
    lateinit var editor: SharedPreferences.Editor

    private lateinit var repository: MealRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        `when`(prefs.edit()).thenReturn(editor)
        `when`(editor.putString(anyString(), anyString())).thenReturn(editor)
        repository = MealRepository(apiService, prefs)
    }

    @Test
    fun `fetchCategories should return success with categories`() {
        val categories = listOf(
            Category("1", "Chicken", "thumb1", "Chicken dishes"),
            Category("2", "Beef", "thumb2", "Beef dishes")
        )
        `when`(apiService.getCategories()).thenReturn(
            Single.just(com.quickbite.app.data.models.CategoryResponse(categories))
        )

        val testObserver = repository.fetchCategories().test()
        testObserver.await()

        testObserver.assertValue { resource ->
            resource is Resource.Success && resource.data.size == 2
        }
    }

    @Test
    fun `fetchCategories should return error on network failure`() {
        `when`(apiService.getCategories()).thenReturn(
            Single.error(RuntimeException("Network error"))
        )

        val testObserver = repository.fetchCategories().test()
        testObserver.await()

        testObserver.assertValue { resource ->
            resource is Resource.Error
        }
    }

    @Test
    fun `searchMeals should return meals for matching query`() {
        val meals = listOf(
            Meal(idMeal = "1", strMeal = "Chicken Curry", strCategory = "Chicken")
        )
        `when`(apiService.searchMeals("chicken")).thenReturn(
            Single.just(com.quickbite.app.data.models.MealResponse(meals))
        )

        val testObserver = repository.searchMeals("chicken").test()
        testObserver.await()

        testObserver.assertValue { resource ->
            resource is Resource.Success && resource.data.size == 1
        }
    }

    @Test
    fun `searchMeals should return empty list for non-matching query`() {
        `when`(apiService.searchMeals("xyz")).thenReturn(
            Single.just(com.quickbite.app.data.models.MealResponse(null))
        )

        val testObserver = repository.searchMeals("xyz").test()
        testObserver.await()

        testObserver.assertValue { resource ->
            resource is Resource.Success && resource.data.isEmpty()
        }
    }

    @Test
    fun `toggleFavorite should add meal to favorites`() {
        `when`(prefs.getString("favorites", null)).thenReturn(null)

        val meal = Meal(idMeal = "1", strMeal = "Chicken Curry")
        val isFav = repository.toggleFavorite(meal)

        assertTrue(isFav)
        verify(editor).putString(anyString(), anyString())
        verify(editor).apply()
    }

    @Test
    fun `isFavorite should return true for favorited meal`() {
        val meal = Meal(idMeal = "1", strMeal = "Chicken Curry")
        `when`(prefs.getString("favorites", null)).thenReturn(null)

        repository.toggleFavorite(meal)

        assertTrue(repository.isFavorite("1"))
    }

    @Test
    fun `removeFavorite should remove meal from favorites`() {
        val meal = Meal(idMeal = "1", strMeal = "Chicken Curry")
        `when`(prefs.getString("favorites", null)).thenReturn(null)

        repository.toggleFavorite(meal)
        repository.removeFavorite("1")

        assertFalse(repository.isFavorite("1"))
    }
}