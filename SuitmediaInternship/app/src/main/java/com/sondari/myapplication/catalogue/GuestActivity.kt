package com.sondari.myapplication.catalogue

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.sondari.myapplication.adapter.AdapterGuest
import com.sondari.myapplication.data.ModelGuest
import com.sondari.myapplication.databinding.ActivityGuestBinding

class GuestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGuestBinding
    private lateinit var adapterGuest: AdapterGuest
    private val resultCode = 1
    private val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[GuestVm::class.java]


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvGuest.setHasFixedSize(true)
        showRvGuest()
    }

    private fun showRvGuest() {
        adapterGuest = AdapterGuest()

        viewModel.setDataGuest()
        viewModel.getDataGuest().observe(this) {
            adapterGuest.setGuest(it)
            binding.apply {
                rvGuest.layoutManager = GridLayoutManager(this@GuestActivity, 2)
                rvGuest.adapter = adapterGuest
                adapterGuest.setOnItemClickCallback(object : AdapterGuest.OnItemClickCallback {
                    override fun onItemClicked(data: ModelGuest) {

                        val guestBirthDate = data.birthdate
                        val date = guestBirthDate.split("-".toRegex()).toTypedArray()
                        val birthDate = date[2].toInt()

                        if (birthDate % 2 == 0 && birthDate % 3 == 0) {
                            Toast.makeText(this@GuestActivity, "iOS", Toast.LENGTH_LONG).show()
                        }
                        else if (birthDate % 3 == 0) {
                            Toast.makeText(this@GuestActivity, "android", Toast.LENGTH_LONG).show()
                        }
                        else if (birthDate % 2 == 0) {
                            Toast.makeText(this@GuestActivity, "blackberry", Toast.LENGTH_LONG)
                                .show()
                        }
                        else {
                            Toast.makeText(this@GuestActivity, "feature phone", Toast.LENGTH_LONG)
                                .show()
                        }

                        val resultIntent = Intent()
                        resultIntent.putExtra("GUEST NAME", data.name)

                        setResult(resultCode, resultIntent)
                        finish()
                    }
                })
            }
        }

    }
}