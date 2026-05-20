package com.quickbite.app.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.quickbite.app.data.models.Meal
import com.quickbite.app.data.repository.MealRepository
import com.quickbite.app.data.wrapper.Resource
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class FavoritesViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: MealRepository

    private lateinit var viewModel: FavoritesViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = FavoritesViewModel(repository)
    }

    @Test
    fun `loadFavorites should return empty list when no favorites exist`() {
        `when`(repository.getFavorites()).thenReturn(emptyList())

        viewModel.loadFavorites()

        val state = viewModel.favoritesState.value
        assertTrue(state is Resource.Success)
        assertTrue((state as Resource.Success).data.isEmpty())
    }

    @Test
    fun `loadFavorites should return favorites list`() {
        val favorites = listOf(
            Meal(idMeal = "1", strMeal = "Chicken Curry"),
            Meal(idMeal = "2", strMeal = "Beef Stew")
        )
        `when`(repository.getFavorites()).thenReturn(favorites)

        viewModel.loadFavorites()

        val state = viewModel.favoritesState.value
        assertTrue(state is Resource.Success)
        assertEquals(2, (state as Resource.Success).data.size)
    }

    @Test
    fun `removeFavorite should update favorites list`() {
        val favorites = mutableListOf(
            Meal(idMeal = "1", strMeal = "Chicken Curry"),
            Meal(idMeal = "2", strMeal = "Beef Stew")
        )
        `when`(repository.getFavorites()).thenReturn(favorites)

        viewModel.loadFavorites()
        viewModel.removeFavorite("1")

        verify(repository).removeFavorite("1")
    }
}