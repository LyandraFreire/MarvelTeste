package com.example.marveltestitau.presetation.scenes.characterDetails

import android.os.Bundle
import android.view.View
import com.example.marveltestitau.base.BaseFragment
import com.example.marveltestitau.data.model.Characters
import com.example.marveltestitau.databinding.FragmentCharacterDetailsBinding

import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailsFragment: BaseFragment<FragmentCharacterDetailsBinding>(FragmentCharacterDetailsBinding::inflate) {

    private val viewModel: CharacterDetailsViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      wfbuw(arguments?.getSerializable("CHARACTER") as Characters)
    }

    fun wfbuw(characters: Characters){

        binding.txtCharacterDetails.text = characters.description
    }
}