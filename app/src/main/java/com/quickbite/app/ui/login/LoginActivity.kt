package com.quickbite.app.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.quickbite.app.QuickBiteApp
import com.quickbite.app.data.wrapper.Resource
import com.quickbite.app.databinding.ActivityLoginBinding
import com.quickbite.app.ui.main.MainActivity
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

        setupObservers()
        setupListeners()
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
                    binding.emailError.visibility = View.VISIBLE
                    binding.emailError.text = state.message
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
    }

    private fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}