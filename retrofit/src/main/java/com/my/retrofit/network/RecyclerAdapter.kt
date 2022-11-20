package com.my.retrofit.network

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.my.retrofit.R


class RecyclerAdapter(private val dataList: List<DataModel>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val recyclerModel = dataList[position]

        // Text set to the TextView widget
        holder.quoteText.text = recyclerModel.quote
        holder.author.text = recyclerModel.author
        holder.series.text = recyclerModel.series

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val quoteText: TextView = itemView.findViewById(R.id.quoteText)
        val author: TextView = itemView.findViewById(R.id.quoteAuthor)
        val series: TextView = itemView.findViewById(R.id.quoteSeries)

    }

}