package com.sondari.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sondari.myapplication.catalogue.EventActivity
import com.sondari.myapplication.catalogue.GuestActivity
import com.sondari.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val eventCode = 1
    private val guestCode = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.eventButton.setOnClickListener(this)
        binding.guestButton.setOnClickListener(this)

        val extras = intent.extras
        if (extras != null) {
            val nama = extras.getString("NAME")
            binding.username.text = nama
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == eventCode) {
            if (data != null) {
                val eventName = data.getStringExtra("EVENT NAME")
                binding.eventButton.text = eventName
            }
        } else if (requestCode == guestCode) {
            if (data != null) {
                val guestName = data.getStringExtra("GUEST NAME")
                binding.guestButton.text = guestName
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.event_button -> {
                val intent = Intent(this@MainActivity, EventActivity::class.java)
                startActivityForResult(intent, eventCode);
            }
            R.id.guest_button -> {
                val intent = Intent(this@MainActivity, GuestActivity::class.java)
                startActivityForResult(intent, guestCode)
            }
        }
    }
}