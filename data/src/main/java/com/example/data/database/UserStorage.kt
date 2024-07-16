package com.example.data.database

import com.example.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface UserStorage {

    fun getAmountOfCoins(): Flow<Int>

    fun saveCoins(coinsNumber: Int)

    suspend fun getObtainedItems(): Flow<List<Item>>

    suspend fun getAllItems(): Flow<List<Item>>

    suspend fun addItem(item: Item): Long

    fun getMultiplier(): Flow<Int>

    suspend fun saveMultiplier(currentMultiplier: Int)

}