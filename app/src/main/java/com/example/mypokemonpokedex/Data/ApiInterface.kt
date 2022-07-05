package com.example.mypokemonpokedex.Data

import com.example.Data.Pokemon
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("pokemon/?offset=0&limit=50")
    fun getPokemon(): Call<Pokemon>
    @GET("pokemon/{id or name}/")
    fun getPokemonDetails(): Call <PokemonData>

}