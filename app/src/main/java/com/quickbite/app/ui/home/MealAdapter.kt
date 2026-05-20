package com.quickbite.app.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.quickbite.app.R
import com.quickbite.app.data.models.Meal
import com.quickbite.app.databinding.ComponentMealCardBinding

class MealAdapter(
    private val meals: MutableList<Meal> = mutableListOf(),
    private val onMealClick: ((Meal) -> Unit)? = null
) : RecyclerView.Adapter<MealAdapter.MealViewHolder>() {

    fun submitList(list: List<Meal>) {
        meals.clear()
        meals.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val binding = ComponentMealCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MealViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(meals[position])
    }

    override fun getItemCount(): Int = meals.size

    inner class MealViewHolder(
        private val binding: ComponentMealCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(meal: Meal) {
            binding.mealCardTitle.text = meal.strMeal
            binding.mealCardCategory.text = meal.strCategory ?: ""
            binding.mealCardArea.text = meal.strArea ?: ""

            Glide.with(binding.root.context)
                .load(meal.strMealThumb)
                .placeholder(R.drawable.placeholder_meal)
                .error(R.drawable.placeholder_meal)
                .centerCrop()
                .into(binding.mealCardImage)

            binding.root.setOnClickListener {
                onMealClick?.invoke(meal)
            }
        }
    }
}