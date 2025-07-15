package com.test.cryptotut.presentation

sealed class ScreenRoute(val route:String) {
    data object coinListRoute: ScreenRoute("coin_list")
    data object coinDetailRoute: ScreenRoute("coin_detail")
}