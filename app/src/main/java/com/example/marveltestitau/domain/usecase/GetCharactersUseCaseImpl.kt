package com.example.marveltestitau.domain.usecase

import com.example.marveltestitau.data.model.Characters
import com.example.marveltestitau.data.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow

class GetCharactersUseCaseImpl(private val charactersRepository: CharactersRepository): GetCharactersUseCase {

    override fun invoke(): Flow<List<Characters>> {
        return charactersRepository.getCharacters()
    }
}
