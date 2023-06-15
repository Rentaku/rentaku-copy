package com.example.rentakucapstone.dashboard.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rentakucapstone.R

class RekomendasiAdapter(
    private val list: List<String>
) :
    RecyclerView.Adapter<RekomendasiAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvRekomendasi: TextView = itemView.findViewById(R.id.tvRekomendasi)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        val itemView: View = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.rekomendasi_item,
                parent,
                false
            )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvRekomendasi.text = list[position]
    }


    override fun getItemCount(): Int {
        return list.size
    }
}