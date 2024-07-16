package com.example.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ItemEntity::class],
    version = 1
)
abstract class ItemDatabase : RoomDatabase() {

    abstract fun getItemDao(): ItemDao

    companion object {

        private var INSTANCE: ItemDatabase? = null

        fun getDatabase(context: Context): ItemDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context, ItemDatabase::class.java, "items_db"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }

    }

}