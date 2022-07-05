package com.example.mypokemonpokedex.Data

import java.io.Serializable

data class PokemonData(
    val id: Int,
    val name :String,
    val sprites: Sprites
): Serializable
