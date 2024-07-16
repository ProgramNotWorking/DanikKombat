package com.example.danikkombat.presentation.main_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_case.GetAmountOfCoinsUseCase
import com.example.domain.use_case.GetMultiplierUseCase
import com.example.domain.use_case.SaveAmountOfCoinsUseCase
import com.example.domain.use_case.SaveMultiplierUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MainViewModel(
    private val getAmountOfCoinsUseCase: GetAmountOfCoinsUseCase,
    private val saveAmountOfCoinsUseCase: SaveAmountOfCoinsUseCase,
    private val getMultiplierUseCase: GetMultiplierUseCase
) : ViewModel() {

    private val _coinsCounter = MutableStateFlow(0)
    val coinsCounter get() = _coinsCounter

    private val _coinsMultiplier = MutableStateFlow(1)
    val coinsMultiplier get() = _coinsMultiplier

    fun getAmountOfCoins() {
        viewModelScope.launch {
            getAmountOfCoinsUseCase()
                .catch { error ->
                    Log.e("Getting amount of coins process", error.toString())
                }
                .collect {
                    _coinsCounter.value = it
                }
        }
    }

    fun saveCoins(amountOfCoins: Int) {
        viewModelScope.launch {
            saveAmountOfCoinsUseCase(amountOfCoins)
        }
    }

    fun getMultiplier() {
        viewModelScope.launch {
            getMultiplierUseCase()
                .catch { error ->
                    Log.e("Getting current multiplier process", error.toString())
                }
                .collect {
                    _coinsMultiplier.value = it
                }
        }
    }

}