package com.app.lontara.adminofmedistock.network

data class UserGetResponse(
    val address: String,
    val isApproved: Int,
    val block: Int,
    val date_of_account_creation: String,
    val phone_info : String,
    val email: String,
    val id: Int,
    val level: Int,
    val name: String,
    val password: String,
    val phone_number: String,
    val pinCode: String,
    val user_id: String
)