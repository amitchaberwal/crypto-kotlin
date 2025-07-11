package com.test.cryptotut.presentation.coin_screen

import com.test.cryptotut.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coinsList: List<Coin> = emptyList(),
    val error: String = ""
)
