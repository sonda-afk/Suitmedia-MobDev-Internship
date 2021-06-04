package com.sondari.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sondari.myapplication.api.data.ModelEvent
import com.sondari.myapplication.databinding.ListItemEventBinding
import java.util.ArrayList

class AdapterEvent : RecyclerView.Adapter<AdapterEvent.EventViewHolder>() {

    inner class EventViewHolder(private val binding: ListItemEventBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(event: ModelEvent) {
            with(binding) {
                eventName.text = event.name
                eventDate.text = event.date

                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(event)
                }

                Glide.with(itemView.context)
                    .load(event.image)
                    .apply(RequestOptions().override(150, 150))
                    .into(eventImage)
            }
        }
    }

    private val list = ArrayList<ModelEvent>()
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data: ModelEvent)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setEvent(event: List<ModelEvent>?) {
        if (event == null) return
        this.list.clear()
        this.list.addAll(event)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemEventBinding =
            ListItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(itemEventBinding)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}