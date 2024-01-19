package com.example.postsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.postsapp.ui.composable.PostList
import com.example.postsapp.ui.theme.PostsAppTheme
import com.example.postsapp.viewModel.PostViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PostsAppTheme {
                // A surface container using the 'background' color from the theme
                val viewModel: PostViewModel = viewModel()
                PostListScreen(viewModel)
            }
        }
    }
}

@Composable
fun PostListScreen(viewModel: PostViewModel) {
    val posts by viewModel.posts.collectAsState()
    PostList(posts)
}