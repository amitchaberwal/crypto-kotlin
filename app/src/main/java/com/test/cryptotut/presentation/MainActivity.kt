package com.test.cryptotut.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.test.cryptotut.presentation.coin_detail.CoinDetailScreen
import com.test.cryptotut.presentation.coin_screen.CoinListScreen
import com.test.cryptotut.presentation.theme.CryptoTutTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoTutTheme {
                Surface (color = MaterialTheme.colorScheme.background){
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = ScreenRoute.coinListRoute.route){
                        composable(route = ScreenRoute.coinListRoute.route){
                            CoinListScreen(navController = navController)
                        }
                        composable(route = ScreenRoute.coinDetailRoute.route + "/{coinId}"){
                            CoinDetailScreen(navController = navController)
                        }
//                        composable(route = ScreenRoute.coinDetailRoute.route + "/{coinId}", arguments = listOf(
//                            navArgument("coinId"){
//                                type = NavType.StringType
//                            }
//                        )){
//                            CoinDetailScreen(navController = navController)
//                        }
                    }
                }
            }
        }
    }
}