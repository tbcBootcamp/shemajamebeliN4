package com.example.shemajamebeli4.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shemajamebeli4.data.ItemModel
import com.example.shemajamebeli4.network.RetrofitClient.apiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    private val _itemModels = MutableStateFlow<List<ItemModel>>(emptyList())
    val itemModels: StateFlow<List<ItemModel>> get() = _itemModels

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                _loading.value = true
                val data = apiService.getItemModels()
                _itemModels.value = data
            } catch (e: Exception) {
                // Handle error
            } finally {
                _loading.value = false
            }
        }
    }
}