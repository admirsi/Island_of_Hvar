package com.example.islandofhvar.activities

import com.example.islandofhvar.R
import android.icu.text.NumberFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.islandofhvar.databinding.ActivitiesItemBinding

class ActivitiesAdapter(private val items: List<Activities>, private val onItemClick: (Activities) -> Unit)
    : RecyclerView.Adapter<ActivitiesAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ActivitiesItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ActivitiesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activities = items[position]

        with(holder.binding) {
            productImage.load(activities.imageFile) {
                crossfade(true)
            }
            productNameText.text = activities.activityName
            sizeText.text = sizeText.context.resources.getString(
                R.string.product_size_label,
                activities.duration
            )
            priceText.text = NumberFormat.getCurrencyInstance().format(activities.price)
        }

        holder.itemView.setOnClickListener {
            onItemClick(activities)
        }
    }

    override fun getItemCount(): Int = items.size
}