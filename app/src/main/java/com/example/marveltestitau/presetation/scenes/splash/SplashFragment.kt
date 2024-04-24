package com.example.marveltestitau.presetation.scenes.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.marveltestitau.R
import com.example.marveltestitau.base.BaseFragment
import com.example.marveltestitau.databinding.FragmentSplashBinding
import com.example.marveltestitau.presetation.MainActivity

class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    private val SPLASH_DELAY: Long = 3000

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            (activity as MainActivity).navController.navigate(R.id.FragmentHomeNav)
        }, SPLASH_DELAY)
    }
}