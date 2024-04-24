package com.example.marveltestitau.data.source.remote

import com.example.marveltestitau.data.mapper.toCharacter
import com.example.marveltestitau.data.model.Characters
import com.example.marveltestitau.data.source.api.Api
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class CharactersDataSourceImpl(private val api: Api) : CharactersDataSource {

    override fun getCharacters(
        apiKey: String,
        timestamp: String,
        hash: String
    ): Flow<List<Characters>> = flow {
        try {
            val response = api.getCharacters(apiKey, timestamp, hash)
            if (response.isSuccessful && response.body() != null)
                emit(response.body()!!.data.results.map { it.toCharacter() })
        } catch (e: HttpException) {
            emit(emptyList())
        } catch (e: Exception) {
            emit(emptyList())
        }
    }
}