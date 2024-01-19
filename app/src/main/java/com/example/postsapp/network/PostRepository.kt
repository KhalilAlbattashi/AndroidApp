package com.example.postsapp.network

import com.example.postsapp.model.Post
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

object PostRepository {
    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val postListAdapter: JsonAdapter<List<Post>> by lazy {
        val type = Types.newParameterizedType(List::class.java, Post::class.java)
        moshi.adapter(type)
    }

    suspend fun getPosts(): List<Post> = withContext(Dispatchers.IO)  {
        val apiResponse = URL("https://jsonplaceholder.typicode.com/posts").readText()
        return@withContext postListAdapter.fromJson(apiResponse) ?: emptyList()
    }
}
