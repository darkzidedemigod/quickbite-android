package com.quickbite.app.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.quickbite.app.data.models.Ingredient
import com.quickbite.app.databinding.ItemIngredientBinding

class IngredientAdapter(
    private val ingredients: MutableList<Ingredient> = mutableListOf()
) : RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder>() {

    fun submitList(list: List<Ingredient>) {
        ingredients.clear()
        ingredients.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val binding = ItemIngredientBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return IngredientViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.bind(ingredients[position])
    }

    override fun getItemCount(): Int = ingredients.size

    inner class IngredientViewHolder(
        private val binding: ItemIngredientBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(ingredient: Ingredient) {
            binding.ingredientCheckbox.text = "${ingredient.name} - ${ingredient.measure}"
        }
    }
}