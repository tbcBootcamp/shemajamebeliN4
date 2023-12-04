package com.example.shemajamebeli4.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.shemajamebeli4.adapter.ItemModelAdapter
import com.example.shemajamebeli4.databinding.FragmentMessagesBinding
import com.example.shemajamebeli4.viewModel.MyViewModel


class MessagesFragment : BaseFragment<FragmentMessagesBinding>(FragmentMessagesBinding::inflate) {

    private val viewModel: MyViewModel by viewModels()
    private val adapter = ItemModelAdapter()

    override fun setUp() {
        binding.recyclerView.adapter = adapter
        observeViewModel()
    }

    override fun listeners() {
        // Add any listeners if needed
    }

    private fun observeViewModel() {
        lifecycleScope.launchWhenStarted {
            viewModel.itemModels.collect {
                adapter.submitList(it)
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.loading.collect { isLoading ->
                // Handle loading state
            }
        }
    }
}