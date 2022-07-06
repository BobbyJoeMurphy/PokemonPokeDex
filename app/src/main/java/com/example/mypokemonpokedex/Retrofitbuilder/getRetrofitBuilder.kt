package com.example.mypokemonpokedex.Retrofitbuilder

import com.example.mypokemonpokedex.APIinterface.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
const val urlForPokemon = "https://pokeapi.co/api/v2/"

//usage of RETROFIT, https://square.github.io/retrofit/
fun getRetrofitBuilder(): ApiInterface {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(urlForPokemon)
        .build()
        .create(ApiInterface::class.java)
}