package com.example.marveltestitau.data.source.remote

import com.example.marveltestitau.data.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharactersDataSource {
    fun getCharacters(): Flow<List<Characters>>
}