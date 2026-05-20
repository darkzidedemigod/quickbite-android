package com.quickbite.app.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.quickbite.app.QuickBiteApp
import com.quickbite.app.data.models.Meal
import com.quickbite.app.data.wrapper.Resource
import com.quickbite.app.databinding.FragmentFavoritesBinding
import com.quickbite.app.di.ViewModelFactory
import com.quickbite.app.viewmodels.FavoritesViewModel
import javax.inject.Inject

class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var favoritesViewModel: FavoritesViewModel
    private val favoritesAdapter = FavoritesAdapter(
        onMealClick = { meal ->
            val bundle = Bundle().apply {
                putString("mealId", meal.idMeal)
            }
            findNavController().navigate(
                com.quickbite.app.R.id.action_favorites_to_detail,
                bundle
            )
        },
        onRemoveClick = { meal ->
            favoritesViewModel.removeFavorite(meal.idMeal)
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity().application as QuickBiteApp).appComponent.inject(this)
        favoritesViewModel = viewModelFactory.create(FavoritesViewModel::class.java)

        binding.favoritesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.favoritesRecyclerView.adapter = favoritesAdapter

        setupObservers()
        favoritesViewModel.loadFavorites()
    }

    override fun onResume() {
        super.onResume()
        favoritesViewModel.loadFavorites()
    }

    private fun setupObservers() {
        favoritesViewModel.favoritesState.observe(viewLifecycleOwner, Observer { resource ->
            when (resource) {
                is Resource.Success -> {
                    if (resource.data.isEmpty()) {
                        binding.emptyStateView.visibility = View.VISIBLE
                        binding.favoritesRecyclerView.visibility = View.GONE
                    } else {
                        binding.emptyStateView.visibility = View.GONE
                        binding.favoritesRecyclerView.visibility = View.VISIBLE
                        favoritesAdapter.submitList(resource.data)
                    }
                }
                else -> {}
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}