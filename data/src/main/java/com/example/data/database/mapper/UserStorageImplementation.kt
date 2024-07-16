package com.example.data.database.mapper

import android.content.Context
import androidx.core.content.edit
import com.example.data.database.ItemDao
import com.example.data.database.UserStorage
import com.example.domain.model.Item
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

private const val SHARED_PREFERENCES_KEY = "SP_KEY"
private const val COINS_KEY = "COINS_KEY"
private const val MULTIPLIER_KEY = "MULTIPLIER_KEY"

class UserStorageImplementation(
    val mapper: ItemMapper,
    val dao: ItemDao,
    context: Context
) : UserStorage {

    private val sp = context.getSharedPreferences(
        SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE
    )

    override fun getAmountOfCoins(): Flow<Int> {
        return flowOf(sp.getInt(COINS_KEY, 0))
    }

    override fun saveCoins(coinsNumber: Int) {
        sp.edit { putInt(COINS_KEY, coinsNumber) }
    }

    override suspend fun getObtainedItems(): Flow<List<Item>> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllItems(): Flow<List<Item>> {
        TODO("Not yet implemented")
    }

    override suspend fun addItem(item: Item): Long {
        TODO("Not yet implemented")
    }

    override fun getMultiplier(): Flow<Int> {
        return flowOf(sp.getInt(MULTIPLIER_KEY, 1))
    }

    override suspend fun saveMultiplier(currentMultiplier: Int) {
        sp.edit { putInt(MULTIPLIER_KEY, currentMultiplier) }
    }

}