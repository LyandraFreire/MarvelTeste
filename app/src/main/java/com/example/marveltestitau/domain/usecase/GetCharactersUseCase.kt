package com.example.marveltestitau.domain.usecase

import com.example.marveltestitau.data.model.Characters
import kotlinx.coroutines.flow.Flow

interface GetCharactersUseCase {

    operator fun invoke(): Flow<List<Characters>>

}