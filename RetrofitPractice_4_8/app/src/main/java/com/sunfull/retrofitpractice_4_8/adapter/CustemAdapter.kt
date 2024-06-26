package com.sunfull.retrofitpractice_4_8.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sunfull.retrofitpractice_4_8.R
import com.sunfull.retrofitpractice_4_8.model.Plant

class CustomAdapter(val context: Context, val dataSet : List<Plant>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val textView :TextView = view.findViewById(R.id.textArea)
        val iv : ImageView = view.findViewById(R.id.iv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = dataSet[position].name
        Glide.with(context)
            .load(dataSet[position].imageUrl)
            .into(holder.iv)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}