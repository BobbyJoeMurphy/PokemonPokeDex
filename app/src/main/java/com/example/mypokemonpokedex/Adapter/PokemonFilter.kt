package com.example.mypokemonpokedex.Adapter

import android.widget.Filter
import com.example.Data.Result

class PokemonFilter(
    private val adapter: CustomFilterableAdapter<Result>,
    private val notifyListener: () -> Unit
) : Filter() {
    override fun performFiltering(constraint: CharSequence?): FilterResults {
        val filterResults = FilterResults()
        constraint ?: return filterResults
        if (constraint.isNotEmpty()) {
            filterResults.values = adapter.getAllItems().filter {
                it.name.startsWith(constraint)
            }

        } else {
            filterResults.values = adapter.getAllItems()
        }
        return filterResults

    }


    @Suppress("UNCHECKED_CAST")
    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        adapter.setCurrentItems(results?.values as List<Result>)
        notifyListener()
    }
}