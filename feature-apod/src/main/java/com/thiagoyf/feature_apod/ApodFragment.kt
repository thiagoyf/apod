package com.thiagoyf.feature_apod

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.thiagoyf.core_model.data.Apod
import com.thiagoyf.feature_apod.databinding.FragmentApodBinding
import com.thiagoyf.feature_apod.model.ApodUiState
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.Exception

class ApodFragment : Fragment() {

    private val apodViewModel: ApodViewModel by viewModel()

    private var _binding: FragmentApodBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentApodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpUiState()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpUiState() {
        lifecycleScope.launch {
            apodViewModel.uiState
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                    when (it) {
                        is ApodUiState.Loading -> showLoading()
                        is ApodUiState.Success -> showSuccessState(it.apod)
                        is ApodUiState.Error -> showErrorState()
                    }
                }
        }
    }

    private fun showLoading() {
        binding.loaderView.visibility = VISIBLE
        hideSuccessState()
        hideErrorState()
    }

    private fun hideLoading() {
        binding.loaderView.visibility = GONE
    }

    private fun showSuccessState(data: Apod) {
        binding.scrollableContent.visibility = VISIBLE
        hideLoading()
        hideErrorState()

        Glide.with(requireContext())
            .load(data.url)
            .into(binding.apodImage)

        binding.apodDate.text = data.date
        binding.apodTitle.text = data.title
        binding.apodExplanation.text = data.explanation
        binding.apodCopyright.text = data.copyright
    }

    private fun hideSuccessState() {
        binding.scrollableContent.visibility = GONE
    }

    private fun showErrorState() {
        binding.errorView.visibility = VISIBLE
        hideLoading()
        hideSuccessState()

        binding.errorView.setError {
            apodViewModel.load()
        }
    }

    private fun hideErrorState() {
        binding.errorView.visibility = GONE
    }
}