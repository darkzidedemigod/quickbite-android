package com.quickbite.app.data.models

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("idCategory")
    val idCategory: String,

    @SerializedName("strCategory")
    val strCategory: String,

    @SerializedName("strCategoryThumb")
    val strCategoryThumb: String? = null,

    @SerializedName("strCategoryDescription")
    val strCategoryDescription: String? = null
)

data class CategoryResponse(
    @SerializedName("categories")
    val categories: List<Category>?
)