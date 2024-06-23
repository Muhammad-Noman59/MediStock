package com.app.lontara.medicalstoreapp.screens.viewModel

sealed class StateMange(var name : String) {

    object DEFAULT : StateMange("DEFAULT")
    object FAILED : StateMange("FAILED")
    object SUCCESS : StateMange("SUCCESS")
    object LOADING : StateMange("LOADING")
}