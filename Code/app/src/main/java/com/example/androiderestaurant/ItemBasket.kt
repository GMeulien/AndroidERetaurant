package com.example.androiderestaurant

import modele.Dish
import java.io.Serializable

data class ItemBasket (var quantity: Int, val dish: Dish ): Serializable