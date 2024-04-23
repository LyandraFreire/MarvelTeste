package com.example.marveltestitau.presetation.scenes.characterDetails

import androidx.lifecycle.ViewModel
import com.example.marveltestitau.data.model.Characters
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CharacterDetailsViewModel: ViewModel() {

    private val _character = MutableStateFlow<List<Characters>>(emptyList())
    val characters: StateFlow<List<Characters>> = _character

}