package com.app.lontara.medicalstoreapp.API

data class GetUserRes (
    val address: String,
    val block: Int,
    val date_of_account_creation: String,
    val email: String,
    val id: Int,
    val isApproved: Int,
    val level: Int,
    val name: String,
    val password: String,
    val phone_info: String,
    val phone_number: String,
    val pinCode: String,
    val user_id: String
)