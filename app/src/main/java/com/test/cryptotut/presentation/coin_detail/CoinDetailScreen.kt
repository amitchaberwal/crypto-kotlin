package com.test.cryptotut.presentation.coin_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun CoinDetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: CoinDetailViewModel = hiltViewModel()
    ) {
    val state = viewModel.state.value
    Scaffold(
        content = { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {

            }
        }
    )

}