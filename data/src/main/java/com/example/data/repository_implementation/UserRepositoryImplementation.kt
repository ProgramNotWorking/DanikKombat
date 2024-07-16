package com.example.data.repository_implementation

import com.example.data.database.UserStorage
import com.example.domain.model.Item
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class UserRepositoryImplementation(
    private val storage: UserStorage
) : UserRepository {

    override fun getAmountOfCoins(): Flow<Int> {
        return storage.getAmountOfCoins()
    }

    override suspend fun saveAmountOfCoins(amountOfCoins: Int) {
        storage.saveCoins(amountOfCoins)
    }

    override suspend fun getObtainedItems(): Flow<List<Item>> {
        return flowOf(emptyList())
    }

    override suspend fun getAllItems(): Flow<List<Item>> {
        return flowOf(emptyList())
    }

    override suspend fun addItem(item: Item): Flow<Item> {
        return flowOf()
    }

    override fun getMultiplier(): Flow<Int> {
        return storage.getMultiplier()
    }

    override suspend fun saveMultiplier(currentMultiplier: Int) {
        storage.saveMultiplier(currentMultiplier)
    }

}