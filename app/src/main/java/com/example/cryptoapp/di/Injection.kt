package com.example.cryptoapp.di

import com.example.cryptoapp.data.CoinRepository

object Injection {

    fun provideRepository(): CoinRepository {
        return CoinRepository.getInstance()
    }
}