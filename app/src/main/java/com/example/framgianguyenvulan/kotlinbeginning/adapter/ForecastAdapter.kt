package com.example.framgianguyenvulan.kotlinbeginning.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by FRAMGIA\nguyen.vu.lan on 06/10/2017.
 */
class ForecastAdapter(val items: List<String>) : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

}