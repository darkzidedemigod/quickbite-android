package com.quickbite.app.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.quickbite.app.QuickBiteApp
import com.quickbite.app.data.wrapper.Resource
import com.quickbite.app.databinding.FragmentHomeBinding
import com.quickbite.app.di.ViewModelFactory
import com.quickbite.app.viewmodels.HomeViewModel
import javax.inject.Inject

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var homeViewModel: HomeViewModel
    private val categoryAdapter = CategoryAdapter(onCategoryClick = { category ->
        homeViewModel.searchMeals(category.strCategory)
    })
    private val featuredAdapter = MealAdapter(onMealClick = { meal ->
        val bundle = Bundle().apply {
            putString("mealId", meal.idMeal)
        }
        findNavController().navigate(
            com.quickbite.app.R.id.action_home_to_detail,
            bundle
        )
    })
    private val searchResultsAdapter = MealAdapter(onMealClick = { meal ->
        val bundle = Bundle().apply {
            putString("mealId", meal.idMeal)
        }
        findNavController().navigate(
            com.quickbite.app.R.id.action_home_to_detail,
            bundle
        )
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity().application as QuickBiteApp).appComponent.inject(this)
        homeViewModel = viewModelFactory.create(HomeViewModel::class.java)

        setupRecyclerViews()
        setupSearchBar()
        setupSwipeRefresh()
        setupObservers()
    }

    private fun setupRecyclerViews() {
        binding.categoriesRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.categoriesRecyclerView.adapter = categoryAdapter

        binding.featuredRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.featuredRecyclerView.adapter = featuredAdapter

        binding.searchResultsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.searchResultsRecyclerView.adapter = searchResultsAdapter
    }

    private fun setupSearchBar() {
        binding.searchBar.getSearchObservable()
            .subscribe { query ->
                homeViewModel.searchMeals(query)
            }

        binding.searchBar.setHint(com.quickbite.app.R.string.search_hint)
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            homeViewModel.loadCategories()
            homeViewModel.loadFeaturedMeals()
            binding.swipeRefresh.isRefreshing = false
        }
    }

    private fun setupObservers() {
        homeViewModel.categoriesState.observe(viewLifecycleOwner, Observer { resource ->
            when (resource) {
                is Resource.Loading -> {
                    binding.loadingView.visibility = View.VISIBLE
                    binding.loadingView.show()
                }
                is Resource.Success -> {
                    binding.loadingView.hide()
                    binding.emptyStateView.hide()
                    categoryAdapter.submitList(resource.data)
                }
                is Resource.Error -> {
                    binding.loadingView.hide()
                    binding.emptyStateView.setEmptyState(
                        title = "Error",
                        subtitle = resource.message
                    )
                    binding.emptyStateView.show()
                }
                else -> {}
            }
        })

        homeViewModel.featuredMeals.observe(viewLifecycleOwner, Observer { resource ->
            when (resource) {
                is Resource.Loading -> {
                    binding.loadingView.visibility = View.VISIBLE
                    binding.loadingView.show()
                }
                is Resource.Success -> {
                    binding.loadingView.hide()
                    featuredAdapter.submitList(resource.data)
                }
                is Resource.Error -> {
                    binding.loadingView.hide()
                }
                else -> {}
            }
        })

        homeViewModel.searchResults.observe(viewLifecycleOwner, Observer { resource ->
            when (resource) {
                is Resource.Loading -> {
                    binding.loadingView.visibility = View.VISIBLE
                    binding.loadingView.show()
                }
                is Resource.Success -> {
                    binding.loadingView.hide()
                    if (resource.data.isNotEmpty()) {
                        binding.featuredLabel.visibility = View.GONE
                        binding.featuredRecyclerView.visibility = View.GONE
                        binding.searchResultsRecyclerView.visibility = View.VISIBLE
                        searchResultsAdapter.submitList(resource.data)
                    } else {
                        binding.searchResultsRecyclerView.visibility = View.GONE
                        binding.featuredLabel.visibility = View.VISIBLE
                        binding.featuredRecyclerView.visibility = View.VISIBLE
                        searchResultsAdapter.submitList(emptyList())
                    }
                }
                is Resource.Error -> {
                    binding.loadingView.hide()
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