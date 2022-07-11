package com.example.mars.aprilfive.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SubcategoryProductResponse(

	@field:SerializedName("subcategory")
	val subcategory: List<SubcategoryItem?>? = null
) : Parcelable

@Parcelize
data class SubcategoryItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("sc_id")
	var scId: Int? = null,

	@field:SerializedName("c_id")
	val cId: Int? = null,
	@field:SerializedName("size")
val size: String? = null
) : Parcelable
