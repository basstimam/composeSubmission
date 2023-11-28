package com.example.cryptoapp.ui.theme.screen.home

import android.app.Application
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.R
import com.example.cryptoapp.data.CoinRepository
import com.example.cryptoapp.model.Coin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: CoinRepository, app: Application): ViewModel(){

    init {
        val appName = app.resources.getString(app.applicationInfo.labelRes)
        val appName2 = app.getString(R.string.app_name)

        Log.d("HomeViewModel", "App name from app: $appName")
        Log.d("HomeViewModel", "App name from string: $appName2")
    }

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