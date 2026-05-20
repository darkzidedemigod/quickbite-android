package com.quickbite.app.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.quickbite.app.R

class LoadingView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val loadingMessage: TextView
    private val progressBar: ProgressBar

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.component_loading, this, true)

        loadingMessage = findViewById(R.id.loadingMessage)
        progressBar = findViewById(R.id.loadingProgress)

        context.obtainStyledAttributes(attrs, R.styleable.LoadingView).apply {
            try {
                val message = getString(R.styleable.LoadingView_loadingMessage)
                if (!message.isNullOrBlank()) {
                    loadingMessage.text = message
                }
            } finally {
                recycle()
            }
        }
    }

    fun setMessage(message: String) {
        loadingMessage.text = message
    }

    fun show() {
        visibility = VISIBLE
    }

    fun hide() {
        visibility = GONE
    }
}