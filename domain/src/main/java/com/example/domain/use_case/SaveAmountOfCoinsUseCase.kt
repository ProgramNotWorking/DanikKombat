package com.example.domain.use_case

import com.example.domain.repository.UserRepository

class SaveAmountOfCoinsUseCase(private val repository: UserRepository) {

    suspend operator fun invoke(coinsNumber: Int) = repository.saveAmountOfCoins(coinsNumber)

}