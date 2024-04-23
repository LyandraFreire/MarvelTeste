package com.example.marveltestitau.data.repository

import com.example.marveltestitau.data.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    fun getCharacters(): Flow<List<Characters>>
}