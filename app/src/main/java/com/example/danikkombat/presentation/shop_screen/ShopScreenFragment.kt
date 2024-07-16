package com.example.danikkombat.presentation.shop_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.danikkombat.databinding.ShopScreenBinding
import com.example.danikkombat.presentation.base.NavigationConstants
import com.example.danikkombat.presentation.base.NavigationFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShopScreenFragment : NavigationFragment() {

    private lateinit var binding: ShopScreenBinding
    private val viewModel by viewModel<ShopViewModel>()
    override val backStackTag: String
        get() = NavigationConstants.SHOP_TAG

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ShopScreenBinding.inflate(inflater, container, false)

        // TODO: toggle some methods here

        return binding.root
    }

    private fun setupObservers() {

    }

}