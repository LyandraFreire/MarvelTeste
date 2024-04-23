package com.example.marveltestitau.domain.usecase

import com.example.marveltestitau.data.model.Characters
import com.example.marveltestitau.data.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow

class GetCharactersUseCaseImpl(private val charactersRepository: CharactersRepository) :
    CharactersUseCase {

    override fun invoke(apiKey: String, timestamp: String, hash: String): Flow<List<Characters>> {
        return charactersRepository.getCharacters(apiKey, timestamp, hash)
    }
}