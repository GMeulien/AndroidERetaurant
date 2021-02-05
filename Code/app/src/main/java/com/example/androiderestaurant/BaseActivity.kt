package com.example.androiderestaurant;

import android.content.Intent
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity(): AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val cartMenuView = menu?.findItem(R.id.basket)?.actionView

        val sharedPreferences = getSharedPreferences(DetailsActivity.APP_PREFS, MODE_PRIVATE)

        val cartQuantity = sharedPreferences.getInt("cart_count", 0)

        val textView = cartMenuView?.findViewById<TextView>(R.id.notif_text)
        textView?.text = "" + cartQuantity.toString()

        cartMenuView?.setOnClickListener{
            val didier = Intent(this, BasketActivity::class.java)
            startActivity(didier)
        }
        return super.onCreateOptionsMenu(menu)
    }
}


