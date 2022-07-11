package com.example.mars.aprilfive.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.codenamaste.activity.model.Coffee
import com.example.mars.aprilfive.dao.CoffeeDAO

@Database(entities = [Coffee::class], version = 3)

 abstract class CoffeeDatabase:RoomDatabase() {
abstract fun CoffeeDAO(): CoffeeDAO

}