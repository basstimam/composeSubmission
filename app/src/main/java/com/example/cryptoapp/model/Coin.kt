package com.example.cryptoapp.model

data class Coin(
    val id: String,
    val symbol: String,
    val name: String,
    val ethAddress: String,
    val price: Double,
    val volume24h: String,
    val photoUrl: String,
)
