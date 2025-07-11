package com.test.cryptotut.presentation

sealed class ScreenRoute(val route:String) {
    object coinListRoute: ScreenRoute("coin_list")
    object coinDetailRoute: ScreenRoute("coin_detail")
}