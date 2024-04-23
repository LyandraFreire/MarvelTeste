package com.example.marveltestitau.presetation.scenes.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marveltestitau.data.model.Characters
import com.example.marveltestitau.domain.usecase.CharactersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val charactersUseCase: CharactersUseCase) : ViewModel() {

    private val _character = MutableStateFlow<List<Characters>>(emptyList())
    val characters: StateFlow<List<Characters>> = _character

    private val _error = MutableSharedFlow<Unit?>()
    val error = _error.asSharedFlow()

    fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            val apiKey = "b7e14bab409c70a5c4e7c2b319c09d7b"
            val timestamp = "1682982412"
            val hash = "3482f01e9bf207a437a4b621c91339ad"

            charactersUseCase.invoke(
                apiKey, timestamp, hash
            ).collect { result ->
                if (result.isNotEmpty()) {
                    _character.emit(result)
                } else {
                    _error.emit(Unit)
                }
            }
        }
    }
}
