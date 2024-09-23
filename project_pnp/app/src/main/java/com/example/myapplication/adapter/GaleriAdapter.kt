package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.GaleriPhoto
import com.example.myapplication.R
import com.example.myapplication.model.ModelGaleri

class GaleriAdapter (
    private val getActivity: GaleriPhoto,
    private  val galeriList :List<ModelGaleri>

) : RecyclerView.Adapter<GaleriAdapter.MyViewHolder>(){
    class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

        val txtMovie : TextView = itemView.findViewById(R.id.txtMovie)
        val imgMovie : ImageView = itemView.findViewById(R.id.imgMovie)
        val cardMovie : CardView = itemView.findViewById(R.id.CardMovie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_galeri_card,parent,false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return galeriList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtMovie.text = galeriList[position].title
        holder.imgMovie.setImageResource(galeriList[position].image)
        // supaya bisa di klik
        holder.cardMovie.setOnClickListener(){

            Toast.makeText(getActivity,galeriList[position].title, Toast.LENGTH_SHORT).show()

        }
    }
}