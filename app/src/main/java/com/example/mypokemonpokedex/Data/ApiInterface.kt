package com.example.mypokemonpokedex.Data

import com.example.Data.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("pokemon/?offset=0&limit=50")
    fun getPokemon(): Call<Pokemon>
    @GET("pokemon/{name}")
    fun getPokemonDetails(
        @Path( "name") name:String) : Call <PokemonData>


}