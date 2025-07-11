package com.test.cryptotut.domain.repository

import com.test.cryptotut.data.remote.dto.CoinDetailDto
import com.test.cryptotut.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(id: String): CoinDetailDto
}