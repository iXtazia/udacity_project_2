package com.udacity.asteroidradar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.item.AsteroidItem
import kotlinx.android.synthetic.main.asteroid_view.view.*

class AsteroidAdapter(private val asteroidList: List<AsteroidItem>) :
    RecyclerView.Adapter<AsteroidAdapter.AsteroidViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidViewHolder {
        val asteroidView = LayoutInflater.from(parent.context).inflate(
            R.layout.asteroid_view,
            parent, false
        )

        return AsteroidViewHolder(asteroidView)
    }

    override fun onBindViewHolder(holder: AsteroidViewHolder, position: Int) {
        val item = asteroidList[position]

        holder.asteroidName.text = item.name
        holder.asteroidDate.text = item.date
    }

    override fun getItemCount() = asteroidList.size

    class AsteroidViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val asteroidName: TextView = itemView.name_text_view
        val asteroidDate: TextView = itemView.date_text_view
    }
}