package com.example.mypokemonpokedex.Data

import java.io.Serializable

data class PokemonData(
    val id: Int,
    val name :String,
    val sprites: Sprites,
    val height:Int,
    val weight : Int,
    val base_experience : Int,
    val abilities: List<PokemonAbility>,


): Serializable
