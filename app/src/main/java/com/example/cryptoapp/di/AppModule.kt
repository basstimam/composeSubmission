package com.example.cryptoapp.di

import android.app.Application
import com.example.cryptoapp.data.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepository(app:Application) : CoinRepository {
        return CoinRepository(app)
    }
}