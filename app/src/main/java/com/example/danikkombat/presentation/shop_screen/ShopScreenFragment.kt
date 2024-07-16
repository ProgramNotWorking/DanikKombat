package com.example.danikkombat.presentation.shop_screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.danikkombat.databinding.ShopScreenBinding
import com.example.danikkombat.presentation.base.NavigationConstants
import com.example.danikkombat.presentation.base.NavigationFragment
import com.example.danikkombat.presentation.base.adapters.ShopMultiplierItemsRecyclerAdapter
import com.example.danikkombat.utils.MultiplierUtils
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShopScreenFragment : NavigationFragment() {

    private lateinit var binding: ShopScreenBinding
    private val viewModel by viewModel<ShopViewModel>()
    override val backStackTag: String
        get() = NavigationConstants.SHOP_TAG

    private lateinit var adapter: ShopMultiplierItemsRecyclerAdapter

    private var amountOfCoins = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ShopScreenBinding.inflate(inflater, container, false)

        // TODO: toggle some methods here
        setupAdapters()
        setupObservers()

        return binding.root
    }

    private fun setupObservers() {
        viewModel.getAmountOfCoins()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                amountOfCoins = viewModel.amountOfCoins.value
            }
        }
    }

    private fun setupAdapters() = binding.apply {
        adapter = ShopMultiplierItemsRecyclerAdapter(
            object : ShopMultiplierItemsRecyclerAdapter.OnItemClickListener {
                override fun onItemClick(position: Int) {

                    // TODO: replace this with normal implementation later

                    if (amountOfCoins < MultiplierUtils().mulItems[position].price) {
                        Toast.makeText(
                            requireContext(), "No money", Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            requireContext(), "YUUUUPI", Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        )
        shopMulRecyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        shopMulRecyclerView.adapter = adapter
    }

}