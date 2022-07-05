package com.example.mypokemonpokedex.Retrofitbuilder

import com.example.mypokemonpokedex.Data.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
val urlForPokemon = "https://pokeapi.co/api/v2/"

fun getRetrofitBuilder(): ApiInterface {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(urlForPokemon)
        .build()
        .create(ApiInterface::class.java)
}