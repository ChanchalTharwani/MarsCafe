package com.example.mars.aprilfive.activity

import com.example.mars.aprilfive.model.ProductResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CategoryInterface {

   // @GET("https://script.googleusercontent.com/macros/echo?user_content_key=CX9Hgx7QqIynFFt9xqbHgkgOW22eqHXaTZ-38JJlc2QTJdDt80iwNcxJQ3e5bUbPJNOh5q6A9BELVdYVFB6RNKgyJzfgfZ41OJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMWojr9NvTBuBLhyHCd5hHa1GhPSVukpSQTydEwAEXFXgt_wltjJcH3XHUaaPC1fv5o9XyvOto09QuWI89K6KjOu0SP2F-BdwUSs0k4hCIAlbez5M-GVmeJQp4IAs7G8ZXaIzq5moWRDMwEhRhAEwhEtNgN1AoUR39vl7IGsXAM8kW5f94nleb7g&lib=MnrE7b2I2PjfH799VodkCPiQjIVyBAxva")//jab call hoga to end point or key chiye hogi
    @GET("https://script.googleusercontent.com/macros/echo?user_content_key=s-JXv_c6JQ-MCm_BZS1rBXtwkjILXK7B7d_VAESeyxL4XKPPwiihjfZ2Lo22vRE5XVAUWPbRP4TsyYlqYA6fS8TU6y3fZxjpOJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMWojr9NvTBuBLhyHCd5hHa1GhPSVukpSQTydEwAEXFXgt_wltjJcH3XHUaaPC1fv5o9XyvOto09QuWI89K6KjOu0SP2F-BdwUSs0k4hCIAlbez5M-GVmeJQp4IAs7G8ZXaIzq5moWRDMwEhRhAEwhEtNgN1AoUR39vl7IGsXAM8kW5f94nleb7g&lib=MnrE7b2I2PjfH799VodkCPiQjIVyBAxva")//jab call hoga to end point or key chiye hogi
    fun getProductItem(): Call<ProductResponse>

}

object ĘxcelService{

    val cafeInstance :CategoryInterface
    init {
        //retrofit object
        val retrofit = Retrofit.Builder()
            .baseUrl("https://script.googleusercontent.com/")  //define base url
            .addConverterFactory(GsonConverterFactory.create())//defin
            .build()
        cafeInstance = retrofit.create(CategoryInterface::class.java)
    }
    }

