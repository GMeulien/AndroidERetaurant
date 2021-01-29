package com.example.androiderestaurant

import modele.Dish
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.androiderestaurant.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        /*binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dish = intent.getSerializableExtra("dish") as? Dish
        binding.dishTitle.text=dish?.title

        binding.listIngredients.text = dish?.ingredients?.joinToString(", ")

        val textView = findViewById<TextView>(R.id.dishTitle)*/
    }
}