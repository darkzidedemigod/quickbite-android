package com.quickbite.app.components

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.inputmethod.EditorInfo
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.quickbite.app.R
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class SearchBarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val searchInput: TextInputEditText
    private val searchLayout: TextInputLayout
    private val searchSubject = PublishSubject.create<String>()
    private var isUpdatingInternally = false

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.component_search_bar, this, true)

        searchLayout = findViewById(R.id.searchLayout)
        searchInput = findViewById(R.id.searchInput)

        searchInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!isUpdatingInternally) {
                    searchSubject.onNext(s?.toString() ?: "")
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        searchInput.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                searchSubject.onNext(searchInput.text?.toString() ?: "")
                true
            } else {
                false
            }
        }
    }

    fun getSearchObservable(): Observable<String> {
        return searchSubject
            .debounce(300, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
    }

    fun setText(text: String, triggerObservable: Boolean = true) {
        if (!triggerObservable) {
            isUpdatingInternally = true
        }
        searchInput.setText(text)
        searchInput.setSelection(text.length)
        if (!triggerObservable) {
            isUpdatingInternally = false
        }
    }

    fun setHint(hint: String) {
        searchLayout.hint = hint
    }

    fun setHint(@StringRes hintResId: Int) {
        searchLayout.setHint(hintResId)
    }

    fun getText(): String {
        return searchInput.text?.toString()?.trim() ?: ""
    }

    fun clear() {
        searchInput.text?.clear()
    }
}