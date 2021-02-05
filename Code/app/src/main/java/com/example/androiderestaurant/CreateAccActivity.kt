package com.example.androiderestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androiderestaurant.databinding.ActivityCreateAccBinding
import org.w3c.dom.Text

private lateinit var binding: ActivityCreateAccBinding

class CreateAccActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreateAccBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    fun check(Name: Text, FName: Text, LP: Text, Mail: Text, Password: Text){
        val recupName: String = Name.toString()
        val recupFName: String = FName.toString()
        val recupLP: String = LP.toString()
        val recupMail: String = Mail.toString()
        val recupPassword: String = Password.toString()

        if (recupName.isEmpty() || recupFName.isEmpty() || recupLP.isEmpty() || recupMail.isEmpty() || recupPassword.isEmpty()){
            Toast.makeText(this, "Vous devez renseigner tous les champs !", Toast.LENGTH_SHORT).show()
            return
        }else{
            binding.submitBtn.setOnClickListener{
                val didier4 = Intent(this, HomeActivity::class.java)
                startActivity(didier4)
            }
            return
        }
    }
}