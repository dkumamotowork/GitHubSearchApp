package com.example.showroomwebtest.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.showroomwebtest.ui.components.RepositoryItemRow

@Composable
fun SearchScreen(query: String, viewModel: SearchViewModel) {
    val state = viewModel.uiState

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "検索クエリ: $query",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (state.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn {
                items(state.repositories) { repo ->
                    RepositoryItemRow(name = repo.name)
                }
            }
        }
    }
}