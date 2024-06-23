package com.app.lontara.medicalstoreapp.screens.home.orders

sealed class OrdersState(var routes: String) {

    object NEW_ORDER : OrdersState("NEW_ORDER")
    object PENDING : OrdersState("PENDING")
    object APPROVED : OrdersState("APPROVED")
    object DISAPPROVED : OrdersState("DISAPPROVED")
}