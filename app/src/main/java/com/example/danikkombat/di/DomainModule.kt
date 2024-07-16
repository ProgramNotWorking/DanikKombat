package com.example.danikkombat.di

import com.example.domain.use_case.GetAmountOfCoinsUseCase
import com.example.domain.use_case.GetMultiplierUseCase
import com.example.domain.use_case.SaveAmountOfCoinsUseCase
import com.example.domain.use_case.SaveMultiplierUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetAmountOfCoinsUseCase> {
        GetAmountOfCoinsUseCase(repository = get())
    }

    factory<SaveAmountOfCoinsUseCase> {
        SaveAmountOfCoinsUseCase(repository = get())
    }

    factory<GetMultiplierUseCase> {
        GetMultiplierUseCase(repository = get())
    }

    factory<SaveMultiplierUseCase> {
        SaveMultiplierUseCase(repository = get())
    }

}