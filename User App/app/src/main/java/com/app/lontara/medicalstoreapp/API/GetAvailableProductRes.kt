package com.app.lontara.medicalstoreapp.API

data class GetAvailableProductRes (
    val category: String,
    val certified: Int,
    val id: Int,
    val price: Double,
    val product_id: String,
    val product_name: String,
    val stock: Int,
    val user_id: String,
    val user_name: String
)