package com.example.danikkombat.di

import com.example.danikkombat.presentation.main_screen.MainViewModel
import com.example.danikkombat.presentation.shop_screen.ShopViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainViewModel> {
        MainViewModel(
            getAmountOfCoinsUseCase = get(),
            saveAmountOfCoinsUseCase = get(),
            getMultiplierUseCase = get()
        )
    }

    viewModel<ShopViewModel> {
        ShopViewModel(
            getAmountOfCoinsUseCase = get()
        )
    }

}