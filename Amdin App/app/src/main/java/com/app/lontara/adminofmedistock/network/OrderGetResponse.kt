package com.app.lontara.adminofmedistock.network

class OrderGetResponse (
    val date_of_order_creation: String,
    val id: Int,
    val isApproved: Int,
    val message: String,
    val order_id: String,
    val price: Double,
    val product_id: String,
    val product_name: String,
    val quantity: Int,
    val total_amount: Double,
    val user_id: String,
    val user_name: String,
    val certified: String,
    val category: String
)