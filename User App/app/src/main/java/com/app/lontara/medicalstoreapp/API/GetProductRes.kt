package com.app.lontara.medicalstoreapp.API


data class GetProductRes(
    val category: String,
    val certified: Int,
    val id: Int,
    val name: String,
    val price: Double,
    val stock: Int
)

