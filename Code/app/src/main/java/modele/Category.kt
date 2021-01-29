package modele

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Category(@SerializedName("name_fr") val name_fr: String, @SerializedName("dishes")val listCategory: List<Dish>): Serializable {

}