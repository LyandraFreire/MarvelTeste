package com.example.marveltestitau.data.source.api

import com.example.marveltestitau.data.source.reponse.ItemResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("characters")
    suspend fun getCharacters(
        @Query("apikey") apiKey: String,
        @Query("ts") timestamp: String,
        @Query("hash") hash: String
    ): Response<ItemResponse>
}