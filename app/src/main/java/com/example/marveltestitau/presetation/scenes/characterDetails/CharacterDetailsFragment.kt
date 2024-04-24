package com.example.marveltestitau.presetation.scenes.characterDetails

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.marveltestitau.base.BaseFragment
import com.example.marveltestitau.data.model.Characters
import com.example.marveltestitau.databinding.FragmentCharacterDetailsBinding

class CharacterDetailsFragment :
    BaseFragment<FragmentCharacterDetailsBinding>(FragmentCharacterDetailsBinding::inflate) {

    companion object {
        const val CHARACTER = "character"
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCharacterDetails(arguments?.getSerializable(CHARACTER) as Characters)
    }

    private fun getCharacterDetails(characters: Characters) {

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