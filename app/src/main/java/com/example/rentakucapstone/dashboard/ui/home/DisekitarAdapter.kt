package com.example.rentakucapstone.dashboard.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rentakucapstone.R

class DisekitarAdapter(
    private val list: List<String>
) :
    RecyclerView.Adapter<DisekitarAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvDisekitar: TextView = itemView.findViewById(R.id.tvDisekitar)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        val itemView: View = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.item_disekitar,
                parent,
                false
            )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DisekitarAdapter.MyViewHolder, position: Int) {
        holder.tvDisekitar.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }
}