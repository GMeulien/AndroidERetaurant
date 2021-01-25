package com.example.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androiderestaurant.databinding.ActivityEntreeBinding

private lateinit var binding: ActivityEntreeBinding

class EntreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entree)

        binding = ActivityEntreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tab= resources.getStringArray(R.array.entrees_name).toList()
        binding.recyclerViewAdap.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewAdap.adapter = Adapter(tab)
    }
}