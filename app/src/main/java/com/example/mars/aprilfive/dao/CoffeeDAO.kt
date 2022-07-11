package com.example.mars.aprilfive.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.codenamaste.activity.model.Coffee


@Dao
interface CoffeeDAO {
    @Insert
    suspend fun insertCoffee(coffee: Coffee)//object which is entity

    @Update
    suspend fun updateCoffee(coffee: Coffee)


    @Query("DELETE FROM coffee WHERE id = :id")
    abstract fun deleteCoffee(id:Int)

    @Query("SELECT * FROM coffee")
    fun getCoffee(): LiveData<List<Coffee>>//return list


}