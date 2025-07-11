package com.test.cryptotut.data.repository

import com.test.cryptotut.data.remote.RemotePaprikaApi
import com.test.cryptotut.data.remote.dto.CoinDetailDto
import com.test.cryptotut.data.remote.dto.CoinDto
import com.test.cryptotut.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: RemotePaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(id: String): CoinDetailDto {
        return api.getCoinById(coinId = id)
    }

}