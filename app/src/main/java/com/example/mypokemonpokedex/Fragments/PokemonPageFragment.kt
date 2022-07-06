package com.example.mypokemonpokedex.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.Data.Result
import com.example.mypokemonpokedex.Data.PokemonData
import com.example.mypokemonpokedex.Retrofitbuilder.getRetrofitBuilder
import com.example.mypokemonpokedex.databinding.FragmentPokemonPageBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PokemonPageFragment : Fragment() {
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
            @SuppressLint("SetTextI18n")
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

                binding.abilityOne.text = responseBody.abilities[0].ability.name
                binding.Height.text = responseBody.height.toString()+" :dm"
                binding.baseExp.text = responseBody.base_experience.toString() +"xp"
                binding.Weight.text = responseBody.weight.toString()+" :dm"





                binding.button.setOnClickListener {
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




