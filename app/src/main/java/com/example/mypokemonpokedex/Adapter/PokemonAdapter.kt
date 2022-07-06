package com.example.mypokemonpokedex.Adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.Data.Result
import com.example.mypokemonpokedex.R


class PokemonAdapter(private var resultList: List<Result>, val callback: (Result) -> Unit) :
    RecyclerView.Adapter<PokemonAdapter.MyViewHolder>(),CustomFilterableAdapter<Result>{

    private var allItems= arrayListOf<Result>()
    init {
        allItems.addAll(resultList)
    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = resultList[position]
        holder.itemView.setOnClickListener {
            callback(currentItem)
            Log.e("TAG",currentItem.name)
        }

        holder.textView.text = currentItem.name
        Glide.with(holder.itemView.context)
            .load(url.plus(currentItem.id).plus(".png"))
            .into(holder.imagePokemons)


    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView3)
        val imagePokemons: ImageView = itemView.findViewById(R.id.imagePokemons)

    }

    companion object {
        const val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun getFilter(): Filter {
        return PokemonFilter(this){
            notifyDataSetChanged()
        }


    }

    override fun getAllItems(): List<Result> {
        return allItems
    }

    override fun getCurrentItems(): List<Result> {
        return resultList

    }

    override fun setCurrentItems(items: List<Result>) {
        resultList = items
    }


}

