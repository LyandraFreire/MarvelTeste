package com.example.marveltestitau.presetation.scenes.characterDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marveltestitau.data.model.Characters
import com.example.marveltestitau.domain.usecase.CharactersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterDetailsViewModel(private val charactersUseCase: CharactersUseCase) : ViewModel() {

    private val _character = MutableStateFlow<List<Characters>>(emptyList())
    val characters: StateFlow<List<Characters>> = _character

    private val _detalhesItem = MutableLiveData<Characters>()
    val detalhesItem: LiveData<Characters> = _detalhesItem


}