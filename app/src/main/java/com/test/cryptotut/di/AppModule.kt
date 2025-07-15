package com.test.cryptotut.di

import com.test.cryptotut.common.Constants
import com.test.cryptotut.data.remote.RemotePaprikaApi
import com.test.cryptotut.data.repository.CoinRepositoryImpl
import com.test.cryptotut.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
object AppModule {

    @Provides
    @Singleton
    fun retrofitProvider(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePeprikaApi(): RemotePaprikaApi{
        return retrofitProvider().create(RemotePaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun providesCoinRepository(api: RemotePaprikaApi): CoinRepository{
        return CoinRepositoryImpl(api)
    }
}