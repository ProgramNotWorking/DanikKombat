package com.example.danikkombat.presentation.base

import android.os.Bundle

abstract class NavigationFragment : BaseFragment() {

    abstract val backStackTag: String

    fun navigate(destination: NavigationDestinations, args: Bundle? = null) {
        navigationManager.navigateTo(
            fragment = destination.fragmentClass.java.newInstance(),
            args = args,
            backStack = backStackTag
        )
    }

}

