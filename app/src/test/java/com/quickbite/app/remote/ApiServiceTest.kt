package com.quickbite.app.remote

import com.quickbite.app.data.remote.ApiEndpoints
import com.quickbite.app.data.remote.ApiService
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var apiService: ApiService

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        val retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `getCategories should parse response correctly`() {
        val jsonResponse = """{
            "categories": [
                {
                    "idCategory": "1",
                    "strCategory": "Chicken",
                    "strCategoryThumb": "https://example.com/chicken.jpg",
                    "strCategoryDescription": "Chicken dishes"
                }
            ]
        }"""

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(jsonResponse)
        )

        val testObserver = apiService.getCategories().test()
        testObserver.await()

        testObserver.assertValue { response ->
            response.categories?.size == 1 && response.categories[0].strCategory == "Chicken"
        }
    }

    @Test
    fun `searchMeals should parse response correctly`() {
        val jsonResponse = """{
            "meals": [
                {
                    "idMeal": "52772",
                    "strMeal": "Chicken Curry",
                    "strCategory": "Chicken",
                    "strArea": "Indian",
                    "strInstructions": "Cook and serve.",
                    "strMealThumb": "https://example.com/curry.jpg"
                }
            ]
        }"""

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(jsonResponse)
        )

        val testObserver = apiService.searchMeals("chicken").test()
        testObserver.await()

        testObserver.assertValue { response ->
            response.meals?.size == 1 && response.meals[0].strMeal == "Chicken Curry"
        }
    }

    @Test
    fun `getCategories should handle empty response`() {
        val jsonResponse = """{"categories": []}"""

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(jsonResponse)
        )

        val testObserver = apiService.getCategories().test()
        testObserver.await()

        testObserver.assertValue { response ->
            response.categories?.isEmpty() == true
        }
    }

    @Test
    fun `searchMeals should handle null meals response`() {
        val jsonResponse = """{"meals": null}"""

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(jsonResponse)
        )

        val testObserver = apiService.searchMeals("nonexistent").test()
        testObserver.await()

        testObserver.assertValue { response ->
            response.meals == null
        }
    }

    @Test
    fun `api should handle server error`() {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(500)
                .setBody("Server Error")
        )

        val testObserver = apiService.getCategories().test()
        testObserver.await()

        testObserver.assertError { error ->
            error.message?.contains("500") == true || error is retrofit2.HttpException
        }
    }
}