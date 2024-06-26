package com.sunfull.room1_5_4.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sunfull.room1_5_4.R
import com.sunfull.room1_5_4.entity.TextEntity

class CustomAdapter(private val dataSet: List<TextEntity>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val textArea : TextView = view.findViewById(R.id.textArea)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.textArea.text = dataSet[position].text
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}