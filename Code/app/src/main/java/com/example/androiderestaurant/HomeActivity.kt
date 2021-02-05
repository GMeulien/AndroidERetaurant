package com.example.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androiderestaurant.databinding.ActivityHomeBinding

private lateinit var binding: ActivityHomeBinding

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.entreesBtn.setOnClickListener {
            val didier=Intent(this,EntreeActivity::class.java)
            didier.putExtra("name", "Entr\u00e9es")
            startActivity(didier)
        }
        binding.platsBtn.setOnClickListener {
            val didier=Intent(this,EntreeActivity::class.java)
            didier.putExtra("name", "Plats")
            startActivity(didier)
        }
        binding.dessertsBtn.setOnClickListener {
            val didier=Intent(this,EntreeActivity::class.java)
            didier.putExtra("name", "Desserts")
            startActivity(didier)
        }
    }
    
}