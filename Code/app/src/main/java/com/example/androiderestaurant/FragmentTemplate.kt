package com.example.androiderestaurant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androiderestaurant.databinding.FragmentTemplateBinding
import com.squareup.picasso.Picasso
import java.lang.reflect.Array.get

private const val ARG_PARAM1 = "param1"

private lateinit var binding: FragmentTemplateBinding

class FragmentTemplate : Fragment() {

    private var param1: String? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentTemplateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let{
            param1 = it.getString(ARG_PARAM1)
        }
        //Picasso.get().load(param1).placeholder(R.drawable.searching).error(R.drawable.error_image).fit().into(binding.fragmentTemplateImage)
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            FragmentTemplate().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}