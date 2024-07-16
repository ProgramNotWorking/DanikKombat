package com.example.danikkombat.utils

class MultiplierUtils {
    val mulItems: List<MultiplierItem> = listOf(
        MultiplierItem(
            2, 100
        ),
        MultiplierItem(
            5, 500
        ),
        MultiplierItem(
            10, 2000
        ),
        MultiplierItem(
            20, 5000
        ),
        MultiplierItem(
            50, 15000
        ),
    )
}

data class MultiplierItem(
    val mul: Int,
    val price: Int
)