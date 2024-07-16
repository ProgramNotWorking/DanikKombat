package com.example.domain.use_case

import com.example.domain.repository.UserRepository

class GetAmountOfCoinsUseCase(private val repository: UserRepository) {

    operator fun invoke() = repository.getAmountOfCoins()

}