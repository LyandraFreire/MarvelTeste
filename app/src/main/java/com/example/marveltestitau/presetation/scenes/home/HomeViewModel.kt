package com.example.marveltestitau.presetation.scenes.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marveltestitau.data.model.Characters
import com.example.marveltestitau.domain.usecase.GetCharactersUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val getCharactersUseCase: GetCharactersUseCase) : ViewModel() {

    private val _character = MutableStateFlow<List<Characters>>(emptyList())
    val characters: StateFlow<List<Characters>> = _character

    private val _error = MutableSharedFlow<Unit?>()
    val error = _error.asSharedFlow()

    fun getCharacters() {
        viewModelScope.launch {
            getCharactersUseCase().collect { result ->
                if (result.isNotEmpty()) {
                    _character.value = result
                } else {
                    _error.emit(Unit)
                }
            }
        }
    }
}
