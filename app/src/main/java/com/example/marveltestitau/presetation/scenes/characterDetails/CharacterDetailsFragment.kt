package com.example.marveltestitau.presetation.scenes.characterDetails

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.marveltestitau.base.BaseFragment
import com.example.marveltestitau.data.model.Characters
import com.example.marveltestitau.databinding.FragmentCharacterDetailsBinding

import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailsFragment: BaseFragment<FragmentCharacterDetailsBinding>(FragmentCharacterDetailsBinding::inflate) {

    private val viewModel: CharacterDetailsViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCharacterDetails(arguments?.getSerializable("CHARACTER") as Characters)
    }

    fun getCharacterDetails(characters: Characters) {

        binding.txtNameCharacterDetails.text = characters.name
        binding.txtCharacterDetails.text = characters.description
        with(binding) {
            Glide.with(root)
                .load(characters.image)
                .centerCrop()
                .into(imgProfileCharacter)
        }
    }
}