package com.example.androiderestaurant

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androiderestaurant.databinding.ActivityDetailsBinding
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import modele.Dish
import java.io.File

private lateinit var binding: ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dish = intent.getSerializableExtra("dish") as Dish
        binding.dishTitle.text=dish.title
        binding.listIngredients.text = dish.getIngredients()

        binding.prixTotal.text = dish.getFormattedPrice()
        var quantityDish: Int = 0
        var prix: Double = dish.getPrice()
        binding.addBtn.setOnClickListener{
            quantityDish ++
            binding.count.text = quantityDish.toString()
            prix= quantityDish*dish.getPrice()
            binding.prixTotal.text="$prix €"
        }
        binding.removeBtn.setOnClickListener{
            if (quantityDish>0){
                quantityDish --
                binding.count.text = quantityDish.toString()
                prix= quantityDish*dish.getPrice()
                binding.prixTotal.text="$prix €"
            }
        }
        binding.total.setOnClickListener{
            val didier = Intent( this, BasketActivity::class.java)
        }
        Picasso.get().load(dish.getFirstPicture()).into(binding.dishImage)
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