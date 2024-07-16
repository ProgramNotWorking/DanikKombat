package com.example.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Query("SELECT * FROM items_table WHERE is_obtained IS 1")
    fun getObtainedItems(): Flow<List<ItemEntity>>

    @Query("SELECT * FROM items_table")
    fun getAllItems(): Flow<List<ItemEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItem(itemEntity: ItemEntity): Long

}