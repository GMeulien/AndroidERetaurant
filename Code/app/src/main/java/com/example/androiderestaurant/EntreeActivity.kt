package com.example.androiderestaurant

import modele.DataResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.androiderestaurant.databinding.ActivityEntreeBinding
import com.google.gson.Gson
import org.json.JSONObject

private lateinit var binding: ActivityEntreeBinding

class EntreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityEntreeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val ss:String = intent.getStringExtra("name").toString()
        binding.title.text = ss


        binding = ActivityEntreeBinding.inflate(layoutInflater)

        val tab= resources.getStringArray(R.array.entrees_name).toList()
        binding.recyclerViewAdap.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewAdap.adapter = Adapter(tab){
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("category", it)
            startActivity(intent)
        }
    }


    fun loadData(){
        val postUrl = "http://test.api.catering.bluecodegames.com/"
        val requestQueue = Volley.newRequestQueue(this)

        val postData = JSONObject()
        postData.put ("id_shop", "1")

        val jsonObjectRequest = JsonObjectRequest(Request.Method.POST, postUrl, postData,
            {
              val gson: DataResult = Gson().fromJson(it.toString(),
                  DataResult::class.java)
              val categories: List<String> = gson.data.map{ it.name_fr }
              displayCategories(categories)
            },
            {
                Log.e("EntreeActivity", it.toString())
            })
        requestQueue.add(jsonObjectRequest)
    }

    private fun displayCategories(categories: List<String>){
        val ctv: RecyclerView=binding.recyclerViewAdap
        ctv.layoutManager = LinearLayoutManager(this)
        ctv.adapter = Adapter(categories) {
            val intent = Intent (this, DetailsActivity::class.java)
            intent.putExtra("category",it)
            startActivity(intent)
        }
    }
}