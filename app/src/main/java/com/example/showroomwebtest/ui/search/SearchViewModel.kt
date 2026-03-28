package com.example.showroomwebtest.ui.search

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.showroomwebtest.data.api.GitHubApiService
import com.example.showroomwebtest.data.model.RepositoryItem
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    // UIに公開する状態
    var uiState by mutableStateOf(SearchUiState())
        private set

    private val apiService = GitHubApiService.create()

    fun fetchRepositories(query: String) {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            try {
                val response = apiService.searchRepositories(query)
                uiState = uiState.copy(
                    repositories = response.items,
                    isLoading = false
                )
            } catch (e: Exception) {
                uiState = uiState.copy(isLoading = false)
                // 本来はここでエラーメッセージの状態を更新
            }
        }
    }
}

// 画面の状態をまとめるデータクラス
data class SearchUiState(
    val repositories: List<RepositoryItem> = emptyList(),
    val isLoading: Boolean = false
)