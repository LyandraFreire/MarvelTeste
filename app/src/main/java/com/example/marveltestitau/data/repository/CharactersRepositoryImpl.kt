package com.example.marveltestitau.data.repository

import com.example.marveltestitau.data.model.Characters
import com.example.marveltestitau.data.source.remote.CharactersDataSource
import kotlinx.coroutines.flow.Flow

class CharactersRepositoryImpl(private val charactersDataSource: CharactersDataSource) :
    CharactersRepository {

    override fun getCharacters(
        apiKey: String,
        timestamp: String,
        hash: String
    ): Flow<List<Characters>> {
        return charactersDataSource.getCharacters(apiKey, timestamp, hash)
    }
}