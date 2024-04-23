package com.example.marveltestitau.data.source.api

import com.example.marveltestitau.data.source.reponse.ItemResponse
import com.example.marveltestitau.utils.HashUtils
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "85fb293bdb9194854bc386c1a078e0a0"
private const val HASH = "0086ead0c14187b0ec614ef16fec6251"

interface Api {
    @GET("characters")
    suspend fun getCharacters(
        @Query("apikey") apiKey: String = API_KEY,
        @Query("ts") timestamp: String = System.currentTimeMillis().toString(),
        @Query("hash") hash: String = HashUtils.generateHash(timestamp)
    ): Response<ItemResponse>
}