package com.quickbite.app.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.quickbite.app.R

class EmptyStateView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val emptyIcon: ImageView
    private val emptyTitle: TextView
    private val emptySubtitle: TextView

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.component_empty_state, this, true)

        emptyIcon = findViewById(R.id.emptyIcon)
        emptyTitle = findViewById(R.id.emptyTitle)
        emptySubtitle = findViewById(R.id.emptySubtitle)

        context.obtainStyledAttributes(attrs, R.styleable.EmptyStateView).apply {
            try {
                val title = getString(R.styleable.EmptyStateView_emptyTitle)
                val subtitle = getString(R.styleable.EmptyStateView_emptySubtitle)
                if (!title.isNullOrBlank()) {
                    emptyTitle.text = title
                }
                if (!subtitle.isNullOrBlank()) {
                    emptySubtitle.text = subtitle
                }
            } finally {
                recycle()
            }
        }
    }

    fun setEmptyState(
        icon: Drawable? = null,
        title: String,
        subtitle: String
    ) {
        icon?.let { emptyIcon.setImageDrawable(it) }
        emptyIcon.visibility = if (icon != null) VISIBLE else GONE
        emptyTitle.text = title
        emptySubtitle.text = subtitle
    }

    fun show() {
        visibility = VISIBLE
    }

    fun hide() {
        visibility = GONE
    }
}