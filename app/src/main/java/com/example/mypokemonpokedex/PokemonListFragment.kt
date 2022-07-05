package com.example.mypokemonpokedex

import PokemonAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.Data.Pokemon
import com.example.mypokemonpokedex.Data.ApiInterface
import com.example.mypokemonpokedex.Retrofitbuilder.getRetrofitBuilder
import com.example.mypokemonpokedex.databinding.FragmentPokemonListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PokemonListFragment : Fragment() {
    private lateinit var binding: FragmentPokemonListBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonListBinding.inflate(inflater, container, false)
        getPokemonList()
        getRetrofitBuilder();


        return binding.root
    }



    private fun getPokemonList() {
        val retrofitData = getRetrofitBuilder().getPokemon()
        retrofitData.enqueue(object : Callback<Pokemon> {
            override fun onResponse(
                call: Call<Pokemon>,
                response: Response<Pokemon>
            ) {
                val responseBody = response.body()!!
               binding.listRecycler.adapter = PokemonAdapter(responseBody.results) {clickedItem->
                   findNavController().navigate(
                       R.id.action_pokemonListFragment_to_pokemonPage,
                       bundleOf("Pokemon" to clickedItem)
               )

                }
                (binding.listRecycler.layoutManager as GridLayoutManager).spanCount = 3


            }
            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                Log.d("MainActivity", "onFailure" + t.message)
            }
        })
    }


}