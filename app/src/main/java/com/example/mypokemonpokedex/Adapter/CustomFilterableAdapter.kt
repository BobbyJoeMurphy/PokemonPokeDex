package com.example.mypokemonpokedex.Adapter

import android.widget.Filterable

interface CustomFilterableAdapter<T> : Filterable {
    fun getAllItems(): List<T>
    fun getCurrentItems(): List<T>
    fun setCurrentItems(items: List<T>)

}