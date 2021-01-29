package modele

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Price(@SerializedName("Price")val price: String):Serializable {

}
