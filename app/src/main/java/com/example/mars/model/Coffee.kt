package com.example.codenamaste.activity.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "coffee")
class Coffee(

    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var name:String = "",
    var qty:Int=0,
    var price:Int=0,
    var image:String="",
    var pizzasize:String=""
): Parcelable