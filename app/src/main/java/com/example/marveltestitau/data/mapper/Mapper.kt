package com.example.marveltestitau.data.mapper

import android.os.Build.ID
import com.example.marveltestitau.data.model.Characters
import com.example.marveltestitau.data.source.reponse.ResultModel


fun ResultModel.toModel(): Characters = Characters(
    id = ID,
    image = "${thumbnail.path}.${thumbnail.extension}",
    name = title,
    description = description ?: "Sem descrição"
)



