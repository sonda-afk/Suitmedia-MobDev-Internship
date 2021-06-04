package com.sondari.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sondari.myapplication.data.ModelGuest
import com.sondari.myapplication.databinding.ListItemGuestBinding
import java.util.ArrayList

class AdapterGuest : RecyclerView.Adapter<AdapterGuest.GuestViewHolder>() {

    inner class GuestViewHolder (private val binding: ListItemGuestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(guest: ModelGuest) {
            with(binding) {
                guestName.text = guest.name

                itemView.setOnClickListener {
                    onItemClickCallback.onItemClicked(guest)
                }
            }
        }
    }

    private val list = ArrayList<ModelGuest>()
    private lateinit var onItemClickCallback: OnItemClickCallback


    interface OnItemClickCallback {
        fun onItemClicked(data: ModelGuest)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setGuest(guest: List<ModelGuest>?) {
        if (guest == null) return
        this.list.clear()
        this.list.addAll(guest)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val itemGuestBinding =
            ListItemGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuestViewHolder(itemGuestBinding)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}