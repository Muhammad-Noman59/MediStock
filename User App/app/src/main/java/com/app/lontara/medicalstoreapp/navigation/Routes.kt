package com.app.lontara.medicalstoreapp.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    object Message

    @Serializable
    object Home

    @Serializable
    object SignUpScreen

    @Serializable
    object SignInScreen


    @Serializable
    object SplashScreen


    @Serializable
    object AvailableProducts



}