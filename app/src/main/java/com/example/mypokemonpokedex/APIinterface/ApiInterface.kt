package com.example.mypokemonpokedex.APIinterface

import com.example.Data.Pokemon
import com.example.mypokemonpokedex.Data.PokemonData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
//creating a call to the api, setting limit to 50, starting at the array index offset of 0,
//as its first in the array
interface ApiInterface {
    @GET("pokemon/?offset=0&limit=50")
    fun getPokemon(): Call<Pokemon>
    @GET("pokemon/{name}")
    fun getPokemonDetails(
        @Path( "name") name:String) : Call <PokemonData>


}