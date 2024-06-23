package com.app.lontara.adminofmedistock.navigation

import com.app.lontara.adminofmedistock.network.UserGetResponse
import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    object AllUsers

    @Serializable
    data class UserDetails
        (
        val address: String,
        val approved: Int,
        val block: Int,
        val date_of_account_creation: String,
        val phoneInfo: String,
        val email: String,
        val id: Int,
        val level: Int,
        val name: String,
        val password: String,
        val phone: String,
        val pinCode: String,
        val user_id: String
    )

    @Serializable
    object Home

    @Serializable
    object AddProduct

    @Serializable
    object AllPendingUsers

    @Serializable
    data class PendingUserDetails(
        val address: String,
        val approved: Int,
        val block: Int,
        val date_of_account_creation: String,
        val phoneInfo: String,
        val email: String,
        val id: Int,
        val level: Int,
        val name: String,
        val password: String,
        val phone: String,
        val pinCode: String,
        val user_id: String
    )

    @Serializable
    object AllDisApprovedUsers

    @Serializable
    data class DisApprovedUserDetails(
        val address: String,
        val approved: Int,
        val block: Int,
        val date_of_account_creation: String,
        val phoneInfo: String,
        val email: String,
        val id: Int,
        val level: Int,
        val name: String,
        val password: String,
        val phone: String,
        val pinCode: String,
        val user_id: String
    )


    @Serializable
    object PendingOrders


    @Serializable
    object AllProducts


    @Serializable
    object AddUser
}
