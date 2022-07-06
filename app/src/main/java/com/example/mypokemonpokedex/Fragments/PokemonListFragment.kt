package com.example.mypokemonpokedex.Fragments

import com.example.mypokemonpokedex.Adapter.PokemonAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.Data.Pokemon
import com.example.Data.Result
import com.example.mypokemonpokedex.R
import com.example.mypokemonpokedex.Retrofitbuilder.getRetrofitBuilder
import com.example.mypokemonpokedex.databinding.FragmentPokemonListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PokemonListFragment : Fragment() {
    private lateinit var binding: FragmentPokemonListBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonListBinding.inflate(inflater, container, false)
        getPokemonList()
        getRetrofitBuilder();

        setupEditText()
        return binding.root
    }
    private fun setupEditText(){
        binding.editTextSearch.addTextChangedListener {
            (binding.listRecycler.adapter as? PokemonAdapter)?.filter?.filter(it)

        }

    }



    private fun getPokemonList() {
        val retrofitData = getRetrofitBuilder().getPokemon()
        retrofitData.enqueue(object : Callback<Pokemon> {
            override fun onResponse(
                call: Call<Pokemon>,
                response: Response<Pokemon>
            ) {
                val responseBody = response.body()!!
                val results = responseBody.results
                setPokemonIds(results)
               binding.listRecycler.adapter = PokemonAdapter(results) {clickedItem->
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
    private fun setPokemonIds(list: List<Result>){
        list.forEachIndexed { index, result -> result.id = index+1 }
    }


}