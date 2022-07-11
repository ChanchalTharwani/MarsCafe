package com.example.mars.aprilfive.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SubcategoryResponse(

	@field:SerializedName("category")
	val category: ArrayList<CategoryItem> = ArrayList()
) : Parcelable

@Parcelize
data class CategoryItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("c_id")
	val cId: Int? = null,

	@field:SerializedName("p_id")
	val pId: Int? = null
) : Parcelable
