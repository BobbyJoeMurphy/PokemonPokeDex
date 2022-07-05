package com.example.mypokemonpokedex

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.example.Data.Result
import com.example.mypokemonpokedex.databinding.FragmentPokemonPageBinding


class PokemonPage : Fragment() {
    private lateinit var binding: FragmentPokemonPageBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPokemonPageBinding.inflate(inflater, container, false)
        var Pokemon = arguments?.getSerializable("Pokemon") as Result

        binding.textView.text = Pokemon.url








        return binding.root
    }
}