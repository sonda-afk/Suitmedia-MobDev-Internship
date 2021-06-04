package com.sondari.myapplication.catalogue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sondari.myapplication.DataDummy
import com.sondari.myapplication.adapter.AdapterEvent
import com.sondari.myapplication.api.data.ModelEvent
import com.sondari.myapplication.databinding.ActivityEventBinding

class EventActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEventBinding
    private lateinit var adapterEvent : AdapterEvent
    private val resultCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showRecycleViewEvent()
    }

    private fun showRecycleViewEvent() {

        adapterEvent = AdapterEvent()
        adapterEvent.setEvent(DataDummy.generateDataDummy())

        binding.rvEvent.apply {
            layoutManager = LinearLayoutManager(this@EventActivity)
            setHasFixedSize(true)
            adapter = adapterEvent

            adapterEvent.setOnItemClickCallback(object : AdapterEvent.OnItemClickCallback {
                override fun onItemClicked(data: ModelEvent) {
                    val resultIntent = Intent()
                    resultIntent.putExtra("EVENT NAME", data.name)
                    setResult(resultCode, resultIntent)
                    finish()
                }

            })

        }


    }
}