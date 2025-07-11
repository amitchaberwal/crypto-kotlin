package com.test.cryptotut.presentation.coin_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.test.cryptotut.presentation.ScreenRoute
import com.test.cryptotut.presentation.coin_screen.components.CoinListItem

@Composable
fun CoinListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel:CoinListViewModel = hiltViewModel()
    ) {
    val state = viewModel.state.value
    Scaffold(
        modifier = Modifier,
        topBar = {},
    ){ innerPadding ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
        ) {
            if(state.coinsList.isNotEmpty()){
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(state.coinsList){ coin ->
                        CoinListItem(coin = coin, modifier = modifier, onItemClick = {
                            navController.navigate(ScreenRoute.coinDetailRoute.route + "/${it.id}")
                        })
                    }
                }
            }
            if(state.error.isNotBlank()){
                Text(
                    text = state.error,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Red,
                )
            }
            if(state.isLoading){
                CircularProgressIndicator()
            }
        }

    }
}
