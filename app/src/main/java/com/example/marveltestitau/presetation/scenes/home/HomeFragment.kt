package com.example.marveltestitau.presetation.scenes.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marveltestitau.base.BaseFragment
import com.example.marveltestitau.data.model.Characters
import com.example.marveltestitau.databinding.FragmentHomeBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {


    private val viewModel: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCharacters()
        setupObservers()
        setupSwipeRefresh()

    }


    private fun showCharactersList(characters: List<Characters>) {
        with(binding) {
            txtErrorList.visibility = View.GONE
            rcyCharacterHome.visibility = View.VISIBLE
            rcyCharacterHome.adapter = HomeCharacterAdapter(characters)
            rcyCharacterHome.layoutManager = LinearLayoutManager(context)
            swipeRefresh.isRefreshing = false
        }
    }


    private fun setupObservers() {
        lifecycleScope.launch {
            viewModel.characters.collectLatest { characters ->
                showCharactersList(characters)
            }
        }

        lifecycleScope.launch {
            viewModel.error.collectLatest { error ->
                if (error != null) {
                    showError()
                }
            }
        }
    }


    private fun showError() {
        with(binding) {
            rcyCharacterHome.visibility = View.GONE
            txtErrorList.visibility = View.VISIBLE
            swipeRefresh.isRefreshing = false
        }
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            this.binding.swipeRefresh.isRefreshing = true
            viewModel.getCharacters()
        }
    }

}