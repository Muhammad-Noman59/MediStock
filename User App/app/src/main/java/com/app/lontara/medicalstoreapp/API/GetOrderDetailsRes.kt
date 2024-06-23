package com.app.lontara.medicalstoreapp.API

data class GetOrderDetailsRes (
    val date_of_order_creation: String,
    val id: Int,
    val isApproved: String,
    val message: String,
    val oder_id: String,
    val product_id: String,
    val product_name: String,
    val quantity: Int,
    val total_amount: Double,
    val user_id: String,
    val user_name: String
)