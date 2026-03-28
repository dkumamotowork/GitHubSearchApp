package com.example.showroomwebtest.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class SearchFragment : Fragment() {

    companion object {
        private const val ARG_QUERY = "query"

        fun newInstance(query: String) = SearchFragment().apply {
            arguments = Bundle().apply { putString(ARG_QUERY, query) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val query = arguments?.getString(ARG_QUERY) ?: ""
        val viewModel: SearchViewModel by viewModels()

        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    LaunchedEffect(query) {
                        viewModel.fetchRepositories(query)
                    }

                    SearchScreen(query = query, viewModel = viewModel)
                }
            }
        }
    }
}