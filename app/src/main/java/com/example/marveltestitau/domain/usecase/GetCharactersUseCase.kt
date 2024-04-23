package com.example.marveltestitau.domain.usecase

import com.example.marveltestitau.data.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharactersUseCase {

    operator fun invoke(
        apiKey: String,
        timestamp: String,
        hash: String
    ): Flow<List<Characters>>

}