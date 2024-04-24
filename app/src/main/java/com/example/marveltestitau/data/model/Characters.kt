package com.example.marveltestitau.data.model

import java.io.Serializable

data class Characters(
    val id: String? = "",
    var image: String? = "",
    val name: String? = "",
    val description: String? = ""
):Serializable