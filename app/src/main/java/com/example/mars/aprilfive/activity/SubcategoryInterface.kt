package com.example.mars.aprilfive.activity

import com.example.mars.aprilfive.model.ProductResponse
import com.example.mars.aprilfive.model.SubcategoryResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SubcategoryInterface {

    @GET("https://script.googleusercontent.com/macros/echo?user_content_key=T2VAHM6KfxU3_PTGkUqliT-MVOHZMBX3a2dQeeK8B1QnMR8mWn1UW4npFeAQ057o-pXg0F9UXgFkRX7jc2J7S5U4CsNTIdXuOJmA1Yb3SEsKFZqtv3DaNYcMrmhZHmUMWojr9NvTBuBLhyHCd5hHa1GhPSVukpSQTydEwAEXFXgt_wltjJcH3XHUaaPC1fv5o9XyvOto09QuWI89K6KjOu0SP2F-BdwUSs0k4hCIAlbez5M-GVmeJQp4IAs7G8ZXaIzq5moWRDMwEhRhAEwhEtNgN1AoUR39W0Ar8EAym2-pg7XV_XBFqA&lib=MnrE7b2I2PjfH799VodkCPiQjIVyBAxva")//jab call hoga to end point or key chiye hogi
    fun getSubcategoryItem(): Call<SubcategoryResponse>

}
object SubcategoryService {

    val cafeInstance: SubcategoryInterface

    init {
        //retrofit object
        val retrofit = Retrofit.Builder()
            .baseUrl("https://script.googleusercontent.com/")  //define base url
            .addConverterFactory(GsonConverterFactory.create())//define
            .build()
        cafeInstance = retrofit.create(SubcategoryInterface::class.java)
    }
}
