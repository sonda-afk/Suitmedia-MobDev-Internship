package com.sondari.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sondari.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.next.setOnClickListener {

            val nama = binding.loginName.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("NAME", nama)
            startActivity(intent)
        }
    }
}