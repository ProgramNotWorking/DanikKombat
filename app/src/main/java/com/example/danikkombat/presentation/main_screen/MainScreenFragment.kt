package com.example.danikkombat.presentation.main_screen

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.danikkombat.R
import com.example.danikkombat.databinding.MainScreenBinding
import com.example.danikkombat.presentation.base.NavigationConstants
import com.example.danikkombat.presentation.base.NavigationDestinations
import com.example.danikkombat.presentation.base.NavigationFragment
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreenFragment : NavigationFragment() {

    private lateinit var binding: MainScreenBinding
    private val viewModel by viewModel<MainViewModel>()
    override val backStackTag: String
        get() = NavigationConstants.MAIN_TAG

    private var counterState = 0
    private var multiplierState = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainScreenBinding.inflate(inflater, container, false)

        initListeners()
        setupGif()
        setupAnimations()

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        setupObservers()
    }

    override fun onPause() {
        super.onPause()
        Log.d("test", "paused")
        viewModel.saveCoins(counterState)
    }

    override fun onStop() {
        super.onStop()
        Log.d("test", "destroyed")
        viewModel.saveCoins(counterState)
    }

    @SuppressLint("SetTextI18n")
    private fun initListeners() = with(binding) {
        clickableImage.setOnClickListener {
            counterState += multiplierState
            coinsCounterTextView.text = "$counterState coins"
        }
        shopButton.setOnClickListener {
            navigate(NavigationDestinations.ToShopFragment)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setupObservers() = with(binding) {
        viewModel.getAmountOfCoins()
        viewModel.getMultiplier()
        lifecycleScope.launch {
            counterState = viewModel.coinsCounter.value
            coinsCounterTextView.text = "$counterState coins"
            multiplierState = viewModel.coinsMultiplier.value
        }
    }

    private fun setupGif() = with(binding) {
        Glide.with(this@MainScreenFragment)
            .load(R.drawable.pig)
            .into(coinGifView)
    }

    private fun setupAnimations() = with(binding) {
        val animator = ValueAnimator.ofFloat(1f, 0.9f, 1f)
        animator.duration = 2000
        animator.addUpdateListener { animation ->
            val value = animation.animatedValue as Float
            clickableImage.scaleX = value
            clickableImage.scaleY = value
        }
        animator.repeatCount = ValueAnimator.INFINITE
        animator.start()
    }

}