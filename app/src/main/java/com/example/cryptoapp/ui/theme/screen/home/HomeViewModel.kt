package com.example.cryptoapp.ui.theme.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.data.CoinRepository
import com.example.cryptoapp.model.Coin
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(private val repository: CoinRepository): ViewModel(){
    private val _groupedCoins = MutableStateFlow(
        repository.getCoins()
            .sortedBy { it.name }
    )
    val groupedCoins: StateFlow<List<Coin>>
        get() = _groupedCoins


    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedCoins.value = repository.searchCoins(_query.value)
            .sortedBy { it.name }

    }
}