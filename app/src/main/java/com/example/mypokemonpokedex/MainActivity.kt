package com.example.mypokemonpokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mypokemonpokedex.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}