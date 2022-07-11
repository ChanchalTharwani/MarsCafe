package com.example.mars.aprilfive.activity

import com.example.mars.aprilfive.model.SubcategoryProductResponse
import com.example.mars.aprilfive.model.SubcategoryResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SubcategoryProductInterface {

    @GET("https://script.googleusercontent.com/macros/echo?user_content_key=nuqq-rdT_NUzgAUp3C9iFy25VWhhpWgn8NiSsestI1IIY0Eo9ukmMBxqXmHZudNYLfhEc84A9Og7jA7tcV5VxNk_RlesLtkoOJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMWojr9NvTBuBLhyHCd5hHa1GhPSVukpSQTydEwAEXFXgt_wltjJcH3XHUaaPC1fv5o9XyvOto09QuWI89K6KjOu0SP2F-BdwUSs0k4hCIAlbez5M-GVmeJQp4IAs7G8ZXaIzq5moWRDMwEhRhAEwhEtNgN1AoUR39zd_dgT7OAiahA_Y_CXirZtQLQl1SL3Pv&lib=MnrE7b2I2PjfH799VodkCPiQjIVyBAxva")//jab call hoga to end point or key chiye hogi
    fun getSubcategoryProductItem(): Call<SubcategoryProductResponse>


}
object SubcategoryProductService {

    val cafeInstance: SubcategoryProductInterface

    init {
        //retrofit object
        val retrofit = Retrofit.Builder()
            .baseUrl("https://script.googleusercontent.com/")  //define base url
            .addConverterFactory(GsonConverterFactory.create())//define
            .build()
        cafeInstance = retrofit.create(SubcategoryProductInterface::class.java)
    }
}