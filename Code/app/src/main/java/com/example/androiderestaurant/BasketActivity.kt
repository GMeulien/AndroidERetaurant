package com.example.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androiderestaurant.databinding.ActivityBasketBinding

private lateinit var binding: ActivityBasketBinding

class BasketActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBasketBinding.inflate(layoutInflater)
        binding.endCommandBtn.setOnClickListener {
            val didier3 = Intent(this, CreateAccActivity::class.java)
            startActivity(didier3)
        }
        setContentView(binding.root)
    }
}