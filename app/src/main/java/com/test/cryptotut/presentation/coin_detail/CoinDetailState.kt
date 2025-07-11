package com.test.cryptotut.presentation.coin_detail

import com.test.cryptotut.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error: String = ""
)
