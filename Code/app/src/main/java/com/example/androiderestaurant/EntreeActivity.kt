package com.example.androiderestaurant

import modele.DataResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.androiderestaurant.databinding.ActivityEntreeBinding
import com.google.gson.Gson
import modele.Category
import modele.Dish
import org.json.JSONObject

private lateinit var binding: ActivityEntreeBinding

class EntreeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityEntreeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val ss:String = intent.getStringExtra("name").toString()

        binding.title.text = ss

        /*val tab= resources.getStringArray(R.array.entrees_name).toList()
        binding.recyclerViewAdap.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewAdap.adapter = Adapter(tab){
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("category", it)
            startActivity(intent)

        }*/
        loadData(ss)
    }

    fun loadData(ss:String){
        val postUrl = "http://test.api.catering.bluecodegames.com/menu"
        val requestQueue = Volley.newRequestQueue(this)

        val postData = JSONObject()
        postData.put ("id_shop", "1")

        val jsonObjectRequest = JsonObjectRequest(Request.Method.POST, postUrl, postData,
            {
                val gson: DataResult = Gson().fromJson(it.toString(), DataResult::class.java)
                gson.data.firstOrNull { it.name == ss}?.listDishes?.let {
                    displayDishes(it)
                }

                val dishes = gson.data.firstOrNull {it.name==ss}?.listDishes
                if (dishes != null){
                    displayDishes(dishes)
                } else{
                    Log.e("EntreeActivity", "Pas de catégorie trouvée")
                }
            },
            {
                Log.e("DetailsActivity", it.toString())
            })
        requestQueue.add(jsonObjectRequest)
    }

    private fun displayDishes(dishes: List<Dish>){
        val ctv: RecyclerView=binding.recyclerViewAdap
        ctv.layoutManager = LinearLayoutManager(this)
        ctv.adapter = Adapter(dishes) {
            val intent = Intent (this, DetailsActivity::class.java)
            intent.putExtra("category",it)
            startActivity(intent)
        }
    }
}


