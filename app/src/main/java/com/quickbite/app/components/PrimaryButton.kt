package com.quickbite.app.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.button.MaterialButton
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.quickbite.app.R

class PrimaryButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val button: MaterialButton
    private val progressIndicator: CircularProgressIndicator

    private var isLoading: Boolean = false
    private var isManualEnabled: Boolean = true
    private var buttonText: String = ""

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.component_primary_button, this, true)

        button = findViewById(R.id.primaryButton)
        progressIndicator = findViewById(R.id.buttonProgress)

        context.obtainStyledAttributes(attrs, R.styleable.PrimaryButton).apply {
            try {
                buttonText = getString(R.styleable.PrimaryButton_buttonText) ?: ""
                button.text = buttonText
            } finally {
                recycle()
            }
        }
        
        updateButtonState()
    }

    fun setText(text: String) {
        buttonText = text
        if (!isLoading) {
            button.text = text
        }
    }

    fun setLoading(loading: Boolean) {
        isLoading = loading
        if (loading) {
            button.text = ""
            progressIndicator.visibility = VISIBLE
        } else {
            button.text = buttonText
            progressIndicator.visibility = GONE
        }
        updateButtonState()
    }

    fun setButtonEnabled(enabled: Boolean) {
        isManualEnabled = enabled
        updateButtonState()
    }

    private fun updateButtonState() {
        // Button is only enabled if not loading AND manually enabled by the form
        button.isEnabled = !isLoading && isManualEnabled
    }

    fun setOnButtonClickListener(listener: OnClickListener) {
        button.setOnClickListener(listener)
    }

    override fun setOnClickListener(l: OnClickListener?) {
        button.setOnClickListener(l)
    }
}