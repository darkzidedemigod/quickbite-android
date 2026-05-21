package com.quickbite.app.ui.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.android.material.snackbar.Snackbar
import com.quickbite.app.QuickBiteApp
import com.quickbite.app.databinding.ActivityRegisterBinding
import com.quickbite.app.di.ViewModelFactory
import com.quickbite.app.ui.login.LoginActivity
import com.quickbite.app.viewmodels.RegisterViewModel
import javax.inject.Inject

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as QuickBiteApp).appComponent.inject(this)
        viewModel = viewModelFactory.create(RegisterViewModel::class.java)

        setupObservers()
        setupListeners()
        setupOnBackPressed()
    }

    private fun setupObservers() {
        viewModel.registerState.observe(this) { state ->
            when (state) {
                is RegisterState.Loading -> {
                    binding.registerButton.setLoading(true)
                    setInputsEnabled(false)
                }
                is RegisterState.Success -> {
                    binding.registerButton.setLoading(false)
                    setInputsEnabled(true)
                    showSuccessAndNavigateBack()
                }
                is RegisterState.Error -> {
                    binding.registerButton.setLoading(false)
                    setInputsEnabled(true)
                    Snackbar.make(binding.root, state.message, Snackbar.LENGTH_LONG).show()
                }
                else -> {
                    binding.registerButton.setLoading(false)
                    setInputsEnabled(true)
                }
            }
        }

        viewModel.isFormValid.observe(this) { isValid ->
            binding.registerButton.setButtonEnabled(isValid)
        }

        viewModel.firstNameError.observe(this) { error ->
            binding.firstNameError.visibility = if (error != null) View.VISIBLE else View.GONE
            binding.firstNameError.text = error
        }

        viewModel.lastNameError.observe(this) { error ->
            binding.lastNameError.visibility = if (error != null) View.VISIBLE else View.GONE
            binding.lastNameError.text = error
        }

        viewModel.emailError.observe(this) { error ->
            binding.emailError.visibility = if (error != null) View.VISIBLE else View.GONE
            binding.emailError.text = error
        }

        viewModel.passwordError.observe(this) { error ->
            binding.passwordError.visibility = if (error != null) View.VISIBLE else View.GONE
            binding.passwordError.text = error
        }

        viewModel.confirmPasswordError.observe(this) { error ->
            binding.confirmPasswordError.visibility = if (error != null) View.VISIBLE else View.GONE
            binding.confirmPasswordError.text = error
        }
    }

    private fun setupListeners() {
        val onFieldsChanged = {
            viewModel.onFieldsChanged(
                binding.firstNameInput.text.toString().trim(),
                binding.lastNameInput.text.toString().trim(),
                binding.emailInput.text.toString().trim(),
                binding.passwordInput.text.toString(),
                binding.confirmPasswordInput.text.toString()
            )
        }

        binding.firstNameInput.doOnTextChanged { _, _, _, _ -> onFieldsChanged() }
        binding.lastNameInput.doOnTextChanged { _, _, _, _ -> onFieldsChanged() }
        binding.emailInput.doOnTextChanged { _, _, _, _ -> onFieldsChanged() }
        binding.passwordInput.doOnTextChanged { _, _, _, _ -> onFieldsChanged() }
        binding.confirmPasswordInput.doOnTextChanged { _, _, _, _ -> onFieldsChanged() }

        binding.registerButton.setOnButtonClickListener {
            val firstName = binding.firstNameInput.text.toString().trim()
            val lastName = binding.lastNameInput.text.toString().trim()
            val email = binding.emailInput.text.toString().trim()
            val password = binding.passwordInput.text.toString()
            val confirmPassword = binding.confirmPasswordInput.text.toString()

            viewModel.register(firstName, lastName, email, password, confirmPassword)
        }

        binding.loginLink.setOnClickListener {
            navigateToLogin()
        }
    }

    private fun setupOnBackPressed() {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navigateToLogin()
            }
        })
    }

    private fun setInputsEnabled(enabled: Boolean) {
        binding.firstNameInput.isEnabled = enabled
        binding.lastNameInput.isEnabled = enabled
        binding.emailInput.isEnabled = enabled
        binding.passwordInput.isEnabled = enabled
        binding.confirmPasswordInput.isEnabled = enabled
    }

    private fun showSuccessAndNavigateBack() {
        val email = binding.emailInput.text.toString().trim()
        val intent = Intent(this, LoginActivity::class.java).apply {
            putExtra("EXTRA_EMAIL", email)
            putExtra("EXTRA_MESSAGE", getString(com.quickbite.app.R.string.register_success))
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        startActivity(intent)
        finish()
    }

    private fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}