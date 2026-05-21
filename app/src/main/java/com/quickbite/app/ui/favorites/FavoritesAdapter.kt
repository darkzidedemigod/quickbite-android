package com.quickbite.app.ui.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.quickbite.app.R
import com.quickbite.app.data.models.Meal
import com.quickbite.app.databinding.ItemFavoriteBinding

class FavoritesAdapter(
    private val favorites: MutableList<Meal> = mutableListOf(),
    private val onMealClick: ((Meal) -> Unit)? = null,
    private val onRemoveClick: ((Meal) -> Unit)? = null
) : RecyclerView.Adapter<FavoritesAdapter.FavoriteViewHolder>() {

    fun submitList(list: List<Meal>) {
        favorites.clear()
        favorites.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding = ItemFavoriteBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(favorites[position])
    }

    override fun getItemCount(): Int = favorites.size

    inner class FavoriteViewHolder(
        private val binding: ItemFavoriteBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(meal: Meal) {
            binding.favoriteMealTitle.text = meal.strMeal
            binding.favoriteMealCategory.text = meal.strCategory ?: ""

            Glide.with(binding.root.context)
                .load(meal.strMealThumb)
                .placeholder(R.drawable.placeholder_meal)
                .error(R.drawable.placeholder_meal)
                .centerCrop()
                .into(binding.favoriteMealImage)

            binding.root.setOnClickListener {
                onMealClick?.invoke(meal)
            }

            binding.removeFavoriteButton.setOnClickListener {
                onRemoveClick?.invoke(meal)
            }
        }
    }
}