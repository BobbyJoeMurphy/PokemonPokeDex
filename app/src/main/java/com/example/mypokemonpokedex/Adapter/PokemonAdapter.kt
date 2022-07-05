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
import java.util.*


class PokemonAdapter(val list: List<Result>, val callback: (Result) -> Unit) :
    RecyclerView.Adapter<PokemonAdapter.MyViewHolder>(){

    private val mainlist = list
    private val searchable = ArrayList<Result>(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonAdapter.MyViewHolder, position: Int) {
        val currentItem = mainlist[position]
        holder.itemView.setOnClickListener {
            callback(currentItem)
            Log.e("TAG",currentItem.name)
        }

        holder.textView.text = currentItem.name
        Glide.with(holder.itemView.context)
            .load(url.plus(position + 1).plus(".png"))
            .into(holder.imagePokemons)


    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView
        val imagePokemons: ImageView

        init {
            textView = itemView.findViewById(R.id.textView3)
            imagePokemons = itemView.findViewById(R.id.imagePokemons)

        }
    }

    companion object {
        const val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"
    }



}

