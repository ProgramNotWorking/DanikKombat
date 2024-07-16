package com.example.domain.repository

import com.example.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getAmountOfCoins(): Flow<Int>

    suspend fun saveAmountOfCoins(amountOfCoins: Int)

    suspend fun getObtainedItems(): Flow<List<Item>>

    suspend fun getAllItems(): Flow<List<Item>>

    suspend fun addItem(item: Item): Flow<Item>

    fun getMultiplier(): Flow<Int>

    suspend fun saveMultiplier(currentMultiplier: Int)

}