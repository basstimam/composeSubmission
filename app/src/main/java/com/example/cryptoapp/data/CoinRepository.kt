package com.example.cryptoapp.data

import com.example.cryptoapp.model.Coin
import com.example.cryptoapp.model.FakeCoinsData

class CoinRepository {
    fun getCoins(): List<Coin>{
        return FakeCoinsData.coins
    }

    fun searchCoins(query: String): List<Coin>{
        return FakeCoinsData.coins.filter { it.name.contains(query, ignoreCase = true) }
    }

    fun getOrderCoins(coinId: String): Coin{
        return FakeCoinsData.coins.first { it.id == coinId }
    }












    companion object {
        @Volatile
        private var instance: CoinRepository? = null

        fun getInstance(): CoinRepository =
            instance ?: synchronized(this) {
                CoinRepository().apply {
                    instance = this
                }
            }
    }
}