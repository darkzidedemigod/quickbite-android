package com.quickbite.app.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.quickbite.app.QuickBiteApp
import com.quickbite.app.R
import com.quickbite.app.data.wrapper.Resource
import com.quickbite.app.databinding.FragmentDetailBinding
import com.quickbite.app.di.ViewModelFactory
import com.quickbite.app.viewmodels.MealDetailViewModel
import javax.inject.Inject

class MealDetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var detailViewModel: MealDetailViewModel
    private val ingredientAdapter = IngredientAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity().application as QuickBiteApp).appComponent.inject(this)
        detailViewModel = viewModelFactory.create(MealDetailViewModel::class.java)

        binding.ingredientsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.ingredientsRecyclerView.adapter = ingredientAdapter

        setupObservers()

        val mealId = arguments?.getString("mealId") ?: return
        detailViewModel.loadMeal(mealId)
    }

    private fun setupObservers() {
        detailViewModel.mealState.observe(viewLifecycleOwner, Observer { resource ->
            when (resource) {
                is Resource.Loading -> {
                    binding.loadingView.visibility = View.VISIBLE
                    binding.loadingView.show()
                }
                is Resource.Success -> {
                    binding.loadingView.hide()
                    bindMeal(resource.data)
                }
                is Resource.Error -> {
                    binding.loadingView.hide()
                }
                else -> {}
            }
        })

        detailViewModel.isFavorite.observe(viewLifecycleOwner, Observer { isFav ->
            val color = if (isFav) {
                ContextCompat.getColor(requireContext(), R.color.favorite_active)
            } else {
                ContextCompat.getColor(requireContext(), R.color.favorite_inactive)
            }
            binding.favoriteFab.imageTintList = ContextCompat.getColorStateList(
                requireContext(), if (isFav) R.color.favorite_active else R.color.favorite_inactive
            )
        })
    }

    private fun bindMeal(meal: com.quickbite.app.data.models.Meal) {
        Glide.with(this)
            .load(meal.strMealThumb)
            .placeholder(R.drawable.placeholder_meal)
            .error(R.drawable.placeholder_meal)
            .centerCrop()
            .into(binding.mealDetailImage)

        binding.mealDetailTitle.text = meal.strMeal
        binding.mealDetailCategory.text = meal.strCategory ?: ""
        binding.mealDetailArea.text = meal.strArea ?: ""
        binding.instructionsText.text = meal.strInstructions ?: "No instructions available"

        val ingredients = meal.getIngredients()
        ingredientAdapter.submitList(ingredients)

        binding.favoriteFab.setOnClickListener {
            detailViewModel.toggleFavorite(meal)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}