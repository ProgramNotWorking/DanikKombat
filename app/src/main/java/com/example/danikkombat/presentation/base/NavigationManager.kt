package com.example.danikkombat.presentation.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.danikkombat.R

class NavigationManager(private val fragmentManager: FragmentManager) {

    fun navigateTo(
        fragment: Fragment,
        container: Int = R.id.fragmentContainerView,
        backStack: String,
        args: Bundle? = null
    ) {
        fragmentManager.beginTransaction()
            .replace(
                container,
                fragment.apply { args?.let { arguments = it } }
            )
            .addToBackStack(backStack)
            .commit()
    }

    fun navigateBack() = fragmentManager.popBackStack()

}