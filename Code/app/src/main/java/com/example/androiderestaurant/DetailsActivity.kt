package com.example.androiderestaurant

import android.content.Context
import modele.Dish
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.androiderestaurant.databinding.ActivityDetailsBinding
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File

private lateinit var binding: ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dish = intent.getSerializableExtra("dish") as? Dish
        binding.dishTitle.text=dish?.title

        binding.listIngredients.text = dish?.ingredients?.joinToString(", ")

        val textView = findViewById<TextView>(R.id.dishTitle)
    }

    private fun saveInBasket(quantity: Int, dish:Dish){
        val file = File(cacheDir.absolutePath + "/$BASKET_FILE")

        if (file.exists()){
            val basket = GsonBuilder().create().fromJson(file.readText(), Basket::class.java)
            basket.items.firstOrNull { it.dish == dish }?.let{
                it.quantity += quantity
            } ?: run {
                basket.items.add(ItemBasket(quantity,dish))
            }
            file.writeText(GsonBuilder().create().toJson(basket))
        }else{
            val basket = Basket(mutableListOf(ItemBasket(quantity, dish)))
            file.writeText((GsonBuilder().create().toJson(basket)))
        }
    }

    /*private fun saveInMemory(basket: Basket, file: File){
        saveDishCount(basket)
        file.writeText(GsonBuilder().create().toJson(basket))
    }

    private fun saveDishCount(basket: Basket){
        val count = basket.items.sumOf { it.quantity }

        val sharedPreferences = getSharedPreferences(APP_PREFS, MODE_PRIVATE)
        sharedPreferences.edit().putInt(BASKET_COUNT, count()).apply()
    }*/
    companion object{
        const val APP_PREFS = "app_prefs"
        const val BASKET_FILE = "basket.json"
        const val BASKET_COUNT = "basket_count"
    }

}