package com.quickbite.app.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import com.quickbite.app.R
import com.quickbite.app.data.models.Meal

class MealCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private val mealImage: ImageView
    private val mealTitle: TextView
    private val mealCategory: TextView
    private val mealArea: TextView

    private var currentMeal: Meal? = null
    private var clickListener: OnMealClickListener? = null

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.component_meal_card, this, true)

        mealImage = findViewById(R.id.mealCardImage)
        mealTitle = findViewById(R.id.mealCardTitle)
        mealCategory = findViewById(R.id.mealCardCategory)
        mealArea = findViewById(R.id.mealCardArea)

        setOnClickListener {
            currentMeal?.let { meal ->
                clickListener?.onMealClick(meal)
            }
        }
    }

    fun bind(meal: Meal) {
        currentMeal = meal
        mealTitle.text = meal.strMeal
        mealCategory.text = meal.strCategory ?: ""
        mealArea.text = meal.strArea ?: ""

        Glide.with(context)
            .load(meal.strMealThumb)
            .placeholder(R.drawable.placeholder_meal)
            .error(R.drawable.placeholder_meal)
            .centerCrop()
            .into(mealImage)
    }

    fun setOnMealClickListener(listener: OnMealClickListener) {
        clickListener = listener
    }

    interface OnMealClickListener {
        fun onMealClick(meal: Meal)
    }
}