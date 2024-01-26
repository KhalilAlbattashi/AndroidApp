package com.example.postsapp.ui.composable

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.postsapp.model.Post

@Composable
fun PostList(posts: List<Post>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp) // Adds space between items
    ) {
        items(posts) { post ->
            val animationDuration = 300
            val animatedElevation = animateDpAsState(
                targetValue = 2.dp,
                animationSpec = tween(durationMillis = animationDuration), label = ""
            )

            Box(modifier = Modifier.padding(animatedElevation.value)) {
                PostItem(post)
            }

//            Divider(thickness = 1.dp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f)) // Decorative divider
        }
    }
}
