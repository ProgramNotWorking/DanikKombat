package com.example.danikkombat.presentation.shop_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_case.GetAmountOfCoinsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ShopViewModel(
    private val getAmountOfCoinsUseCase: GetAmountOfCoinsUseCase
) : ViewModel() {

    private val _amountOfCoins = MutableStateFlow<Int>(0)
    val amountOfCoins get() = _amountOfCoins

    fun getAmountOfCoins() {
        viewModelScope.launch {
            getAmountOfCoinsUseCase()
                .catch { error ->
                    Log.e("Getting amount of coins process", error.toString())
                }
                .collect {
                    _amountOfCoins.value = it
                }
        }
    }

}