package com.app.lontara.medicalstoreapp.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.app.lontara.medicalstoreapp.R
import com.app.lontara.medicalstoreapp.navigation.Routes
import com.app.lontara.medicalstoreapp.screens.viewModel.ViewModel
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(viewModel: ViewModel, navHostController: NavHostController) {

    val userDataFromDatastore = viewModel.userListState.collectAsState()
    var isApproved by rememberSaveable() { mutableStateOf(false) }
    val userId = rememberSaveable() { mutableStateOf("") }


    userDataFromDatastore.value.map {
        if (it.isApproved != null){
            isApproved = it.isApproved
        }
        userId.value = it.userId!!
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo), contentDescription = " App Logo",
            modifier = Modifier.size(300.dp)
        )
    }

    LaunchedEffect(key1 = true) {
        delay(3000)

        if (userId.value.isEmpty()) {
            navHostController.navigate(Routes.SignUpScreen)

        } else if (isApproved) {

            navHostController.navigate(Routes.Home)

        } else {
            navHostController.navigate(Routes.Message)
        }
    }
}





