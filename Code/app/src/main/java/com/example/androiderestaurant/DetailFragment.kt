package com.example.androiderestaurant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androiderestaurant.databinding.ActivityDetailsBinding
import com.squareup.picasso.Picasso
import java.lang.reflect.Array.get

/*private lateinit var binding: FragmentDishPhotoBinding

class DetailFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDishPhotoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString("URL")?.let{
            Picasso.get().load(it).into(binding.photo)
        }
    }

    companion object{
        fun newInstance(picture: String): DetailFragment{
            return DetailFragment().apply{arguments = Bundle().apply { putString("URL", picture) } }
        }
    }
}*/