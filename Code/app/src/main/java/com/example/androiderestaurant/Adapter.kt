package com.example.androiderestaurant

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import com.example.androiderestaurant.databinding.RecyclerRawBinding
import java.util.*


class Adapter(private val categories: List<String>, private val categoriesClickListener: (String) -> Unit): RecyclerView.Adapter<Adapter.CategoryHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryHolder{
        val itemBinding = RecyclerRawBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryHolder(itemBinding)
    }

    override fun getItemCount(): Int = categories.size

    class CategoryHolder(binding: RecyclerRawBinding): RecyclerView.ViewHolder(binding.root){
        val title = binding.entreeName
        val layout = binding.root
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.title.text = categories[position]
        holder.layout.setOnClickListener {
            categoriesClickListener.invoke(categories[position])
        }
    }
}