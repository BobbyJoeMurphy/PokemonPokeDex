package com.example.mypokemonpokedex

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.Data.Result
import com.example.mypokemonpokedex.Data.PokemonData
import com.example.mypokemonpokedex.Retrofitbuilder.getRetrofitBuilder
import com.example.mypokemonpokedex.databinding.FragmentPokemonPageBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PokemonPage : Fragment() {
    private lateinit var binding: FragmentPokemonPageBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPokemonPageBinding.inflate(inflater, container, false)
        var pokemonResult = arguments?.getSerializable("Pokemon") as Result

            val retrofitData = getRetrofitBuilder().getPokemonDetails(pokemonResult.name)
            retrofitData.enqueue(object : Callback<PokemonData> {
                override fun onResponse(
                    call: Call<PokemonData>,
                    response: Response<PokemonData>
                ) {
                    val responseBody = response.body()!!
                    binding.textview.text = responseBody.name
                    Glide.with(binding.imageViewPokemon)
                        .load(responseBody.sprites.front_default)
                        .centerCrop()
                        .into(binding.imageViewPokemon)

                    binding.textview.text = responseBody.abilities[0].ability.name



                    binding.button.setOnClickListener{
                        Glide.with(binding.imageViewPokemon)
                            .load(responseBody.sprites.front_shiny)
                            .centerCrop()
                            .into(binding.imageViewPokemon)
                    }

                }

                override fun onFailure(call: Call<PokemonData>, t: Throwable) {
                    Log.d("MainActivity", "onFailure" + t.message)
                }
            })



        return binding.root
    }



    }




