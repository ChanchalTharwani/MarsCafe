package com.example.mars.aprilfive.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductResponse(

	@field:SerializedName("product")
	val product: List<ProductItem?>? = null
) : Parcelable

@Parcelize
data class ProductItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
) : Parcelable
