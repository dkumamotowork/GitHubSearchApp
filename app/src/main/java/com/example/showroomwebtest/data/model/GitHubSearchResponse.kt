package com.example.showroomwebtest.data.model

data class GitHubSearchResponse(
    val items: List<RepositoryItem>
)

data class RepositoryItem(
    val name: String
)