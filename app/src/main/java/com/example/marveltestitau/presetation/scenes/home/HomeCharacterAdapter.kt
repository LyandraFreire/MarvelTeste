package com.example.marveltestitau.presetation.scenes.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marveltestitau.data.model.Characters
import com.example.marveltestitau.databinding.ItemListHeroBinding


class HomeCharacterAdapter(
    private var characters: List<Characters>
) : RecyclerView.Adapter<HomeCharacterAdapter.CharactersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val binding =
            ItemListHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharactersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int = characters.size

    inner class CharactersViewHolder(private val binding: ItemListHeroBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Characters) {
            with(binding) {
                Glide.with(root)
                    .load(character.image)
                    .centerCrop()
                    .into(imgListPhoto)

                txtNameHero.text = character.name
            }
        }
    }
}

