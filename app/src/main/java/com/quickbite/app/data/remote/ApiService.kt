package com.quickbite.app.data.remote

import com.quickbite.app.data.models.CategoryResponse
import com.quickbite.app.data.models.MealResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(ApiEndpoints.CATEGORIES)
    fun getCategories(): Single<CategoryResponse>

    @GET(ApiEndpoints.SEARCH)
    fun searchMeals(@Query("s") query: String): Single<MealResponse>
}