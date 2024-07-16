package com.example.danikkombat.presentation.base

import androidx.fragment.app.Fragment
import com.example.danikkombat.presentation.shop_screen.ShopScreenFragment
import kotlin.reflect.KClass

sealed class NavigationDestinations(val fragmentClass: KClass<out Fragment>) {

    data object ToShopFragment : NavigationDestinations(ShopScreenFragment::class)

}