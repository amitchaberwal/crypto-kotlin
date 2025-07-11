package com.test.cryptotut.data.remote

import com.test.cryptotut.data.remote.dto.CoinDetailDto
import com.test.cryptotut.data.remote.dto.CoinDto
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface RemotePaprikaApi {
    @GET("/v1/coins")
    suspend fun getCoins(

    ): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}