package com.example.domain.use_case

import com.example.domain.repository.UserRepository

class SaveMultiplierUseCase(private val repository: UserRepository) {

    suspend operator fun invoke(currentMultiplier: Int) = repository.saveMultiplier(currentMultiplier)

}