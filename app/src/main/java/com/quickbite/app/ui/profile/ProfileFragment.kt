package com.quickbite.app.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.quickbite.app.QuickBiteApp
import com.quickbite.app.databinding.FragmentProfileBinding
import com.quickbite.app.di.ViewModelFactory
import com.quickbite.app.ui.login.LoginActivity
import com.quickbite.app.viewmodels.ProfileViewModel
import javax.inject.Inject

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity().application as QuickBiteApp).appComponent.inject(this)
        profileViewModel = viewModelFactory.create(ProfileViewModel::class.java)

        setupObservers()
        setupListeners()

        profileViewModel.loadUser()
    }

    private fun setupObservers() {
        profileViewModel.user.observe(viewLifecycleOwner, Observer { user ->
            if (user != null) {
                val fullName = buildString {
                    if (user.firstName.isNotEmpty()) append(user.firstName)
                    if (user.lastName.isNotEmpty()) {
                        if (isNotEmpty()) append(" ")
                        append(user.lastName)
                    }
                    if (isEmpty()) append(user.displayName)
                }
                binding.profileName.text = fullName
                binding.profileEmail.text = user.email
            }
        })
    }

    private fun setupListeners() {
        binding.logoutButton.setOnClickListener {
            profileViewModel.logout()
            navigateToLogin()
        }

        // Initialize switch from saved preference
        val prefs = requireContext().getSharedPreferences("theme_prefs", 0)
        val isDark = prefs.getBoolean("dark_mode", false)
        binding.themeSwitch.isChecked = isDark

        binding.themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean("dark_mode", isChecked).apply()
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    private fun navigateToLogin() {
        val intent = Intent(requireContext(), LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        requireActivity().finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}