package com.thiagoyf.core_ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.thiagoyf.core_ui.databinding.ErrorViewBinding

class ErrorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = ErrorViewBinding.inflate(LayoutInflater.from(context), this)

    fun setError(clicked: () -> Unit) {
        binding.errorTitle.text = context.getString(R.string.oops)
        binding.errorMessage.text = context.getString(R.string.generic_error_message)
        binding.errorButton.setOnClickListener {
            clicked()
        }
    }
}