package com.app.lontara.medicalstoreapp.screens.signup

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import com.app.lontara.medicalstoreapp.API.CreateUserResponse
import com.app.lontara.medicalstoreapp.screens.viewModel.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
fun onSignUpClick(
    name: String?,
    password: String?,
    repeatPassword: String?,
    email: String?,
    address: String?,
    phone: String?,
    pinCode: String?,
    context: Context,
    viewModel: ViewModel
) {

    if (name!!.isEmpty() || password!!.isEmpty() || repeatPassword!!.isEmpty() || email!!.isEmpty() || address!!.isEmpty() || phone!!.isEmpty() || pinCode!!.isEmpty()) {

        Toast.makeText(context, "Please fill the all details", Toast.LENGTH_SHORT).show()

    } else if (repeatPassword != password) {

        Toast.makeText(context, "Repeat password must be same", Toast.LENGTH_SHORT).show()

    } else {
    viewModel.userCreateRes(
        name = name,
        password = password,
        email = email,
        address = address,
        phoneNumber = phone,
        pinCode = pinCode,
        phoneInfo = getMobileInfo()
    )
    }


}



fun getMobileInfo() : String{

    return "Brand: ${Build.BRAND}" +
            "\nDevice: ${Build.DEVICE}"
}

