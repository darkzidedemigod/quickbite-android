package com.quickbite.app.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.quickbite.app.QuickBiteApp
import com.quickbite.app.data.wrapper.Resource
import com.quickbite.app.databinding.ActivityLoginBinding
import com.quickbite.app.ui.main.MainActivity
import com.quickbite.app.ui.register.RegisterActivity
import com.quickbite.app.viewmodels.LoginViewModel
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    @Inject
    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as QuickBiteApp).appComponent.inject(this)

        handleIntentExtras()
        setupObservers()
        setupListeners()
    }

    private fun handleIntentExtras() {
        intent.getStringExtra("EXTRA_EMAIL")?.let { email ->
            binding.emailInput.setText(email)
        }
        intent.getStringExtra("EXTRA_MESSAGE")?.let { message ->
            Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
        }
    }

    private fun setupObservers() {
        loginViewModel.loginState.observe(this, Observer { state ->
            when (state) {
                is Resource.Loading -> {
                    binding.loginButton.setLoading(true)
                    binding.emailInput.isEnabled = false
                    binding.passwordInput.isEnabled = false
                }
                is Resource.Success -> {
                    binding.loginButton.setLoading(false)
                    binding.emailInput.isEnabled = true
                    binding.passwordInput.isEnabled = true
                    navigateToMain()
                }
                is Resource.Error -> {
                    binding.loginButton.setLoading(false)
                    binding.emailInput.isEnabled = true
                    binding.passwordInput.isEnabled = true
                    Snackbar.make(binding.root, state.message, Snackbar.LENGTH_LONG).show()
                }
                else -> {}
            }
        })

        loginViewModel.emailError.observe(this, Observer { error ->
            binding.emailError.visibility = if (error != null) View.VISIBLE else View.GONE
            binding.emailError.text = error
        })

        loginViewModel.passwordError.observe(this, Observer { error ->
            binding.passwordError.visibility = if (error != null) View.VISIBLE else View.GONE
            binding.passwordError.text = error
        })
    }

    private fun setupListeners() {
        binding.loginButton.setOnButtonClickListener {
            val email = binding.emailInput.text?.toString()?.trim() ?: ""
            val password = binding.passwordInput.text?.toString()?.trim() ?: ""
            loginViewModel.login(email, password)
        }

        binding.registerLink.setOnClickListener {
            navigateToRegister()
        }
    }

    private fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    private fun navigateToRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}