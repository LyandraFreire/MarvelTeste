package com.example.marveltestitau.data.mapper

import com.example.marveltestitau.data.model.Characters
import com.example.marveltestitau.data.source.reponse.ResultModel

fun ResultModel.toCharacter(): Characters {
    return Characters(
        id = this.id,
        image = "${thumbnail.path}.${thumbnail.extension}",
        name = this.name,
        description = this.description ?: "Sem descrição"
    )
}