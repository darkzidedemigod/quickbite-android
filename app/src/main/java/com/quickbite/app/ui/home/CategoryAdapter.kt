package com.quickbite.app.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.quickbite.app.R
import com.quickbite.app.data.models.Category
import com.quickbite.app.databinding.ItemCategoryBinding

class CategoryAdapter(
    private val categories: MutableList<Category> = mutableListOf(),
    private val onCategoryClick: ((Category) -> Unit)? = null
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    fun submitList(list: List<Category>) {
        categories.clear()
        categories.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int = categories.size

    inner class CategoryViewHolder(
        private val binding: ItemCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category) {
            binding.categoryName.text = category.strCategory
            Glide.with(binding.root.context)
                .load(category.strCategoryThumb)
                .placeholder(R.drawable.placeholder_meal)
                .error(R.drawable.placeholder_meal)
                .centerCrop()
                .into(binding.categoryImage)

            binding.root.setOnClickListener {
                onCategoryClick?.invoke(category)
            }
        }
    }
}