package com.example.cryptoapp.ui.theme.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.data.CoinRepository
import com.example.cryptoapp.model.Coin
import com.example.cryptoapp.model.FakeCoinsData
import com.example.cryptoapp.ui.theme.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: CoinRepository) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState<Coin>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Coin>>
        get() = _uiState

    fun getCoinById(coinId: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getOrderCoins(coinId ))
        }
    }
}