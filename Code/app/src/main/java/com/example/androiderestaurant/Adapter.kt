package com.example.androiderestaurant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androiderestaurant.databinding.RecyclerRawBinding
import com.squareup.picasso.Picasso
import modele.Dish


class Adapter(private val dishes: List<Dish>, private val categoriesClickListener: (Dish) -> Unit): RecyclerView.Adapter<Adapter.CategoryHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryHolder{
        val itemBinding = RecyclerRawBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryHolder(itemBinding)
    }

    override fun getItemCount(): Int = dishes.size

    class CategoryHolder(binding: RecyclerRawBinding): RecyclerView.ViewHolder(binding.root){
        val title = binding.entreeName
        val layout = binding.root
        val imageDish = binding.dishPic
        val priceDish = binding.price
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.title.text = dishes[position].title
        holder.priceDish.text = dishes[position].getFormattedPrice()
        Picasso.get().load(dishes[position].getFirstPicture()).into(holder.imageDish)
        holder.layout.setOnClickListener {
            categoriesClickListener.invoke(dishes[position])
        }
    }
}