
package com.cuutt.myfirstjourneys

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Article(
    val title: String,
    val description: String,
    val icon: ImageVector
)

val articles = listOf(
    Article(
        title = "Mastering Jetpack Compose",
        description = "A deep dive into the declarative UI toolkit for Android.",
        icon = Icons.Default.Create
    ),
    Article(
        title = "Kotlin Coroutines for Asynchronous Programming",
        description = "Learn how to write clean and concurrent code.",
        icon = Icons.Default.ThumbUp
    ),
    Article(
        title = "Modern Android Development with Hilt",
        description = "Simplify dependency injection in your Android apps.",
        icon = Icons.Default.Build
    ),
    Article(
        title = "Exploring the new Android 15 Features",
        description = "Discover the latest and greatest features in the new Android version.",
        icon = Icons.Default.DateRange
    ),
    Article(
        title = "State Management in Compose",
        description = "Understand how to manage state effectively in your Jetpack Compose applications.",
        icon = Icons.Default.Star
    ),
    Article(
        title = "Dependency Injection with Koin",
        description = "A pragmatic lightweight dependency injection framework for Kotlin.",
        icon = Icons.Default.Favorite
    ),
    Article(
        title = "Testing in Android",
        description = "Learn how to write unit, integration, and UI tests for your Android apps.",
        icon = Icons.Default.Info
    )
)

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(articles) { article ->
            ArticleItem(article = article)
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Composable
fun ArticleItem(article: Article) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = article.icon,
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .padding(end = 16.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Column {
                Text(
                    text = article.title,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = article.description,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview
@Composable
fun ArticleItemPreview() {
    val article = Article(
        title = "Mastering Jetpack Compose",
        description = "A deep dive into the declarative UI toolkit for Android.",
        icon = Icons.Default.Create
    )
    ArticleItem(article)
}
