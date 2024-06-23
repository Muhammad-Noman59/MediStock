package com.app.lontara.medicalstoreapp.navigation

sealed class BottomTabs(var route : String) {

    object DASHBOARD : BottomTabs("DASHBOARD")

    object SELL : BottomTabs("SELL")

    object ORDERS : BottomTabs("ORDERS")

    object PROFILE : BottomTabs("PROFILE")

}