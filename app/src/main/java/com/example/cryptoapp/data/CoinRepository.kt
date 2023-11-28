package com.example.cryptoapp.data

import android.app.Application
import android.util.Log
import com.example.cryptoapp.R
import com.example.cryptoapp.model.Coin
import com.example.cryptoapp.model.FakeCoinsData



class CoinRepository(private val appContext : Application) {

    init {

        val appName = appContext.resources.getString(appContext.applicationInfo.labelRes)
       Log.d("CoinRepository", "App name from app: $appName")

    }
    fun getCoins(): List<Coin>{
        return FakeCoinsData.coins
    }

    fun searchCoins(query: String): List<Coin>{
        return FakeCoinsData.coins.filter { it.name.contains(query, ignoreCase = true) }
    }

    fun getOrderCoins(coinId: String): Coin{
        return FakeCoinsData.coins.first { it.id == coinId }
    }



}