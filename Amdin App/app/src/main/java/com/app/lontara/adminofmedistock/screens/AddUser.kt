package com.app.lontara.adminofmedistock.screens

import android.os.Build
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.lontara.adminofmedistock.R
import com.app.lontara.adminofmedistock.screens.viewModel.ViewModel
import com.app.lontara.adminofmedistock.ui.theme.BlackColor
import com.app.lontara.adminofmedistock.ui.theme.PrimaryColor
import com.app.lontara.adminofmedistock.ui.theme.WhiteColor


@Composable
fun AddUser(
    navHostController: NavHostController,
    viewModel: ViewModel
) {


    val context = LocalContext.current
    val userName = rememberSaveable { mutableStateOf("") }
    val userNumber = rememberSaveable { mutableStateOf("") }
    val userEmail = rememberSaveable { mutableStateOf("") }
    val userAddress = rememberSaveable { mutableStateOf("") }
    val userPineCode = rememberSaveable { mutableStateOf("") }
    val userPassword = rememberSaveable { mutableStateOf("") }
    val repeatPassword = rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(color = WhiteColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_icon),
                contentDescription = "BAck Icon",
                modifier = Modifier.clickable {
                    navHostController.popBackStack()
                }
            )

            Text(
                text = "Add New User",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = userName.value, onValueChange = {
                userName.value = it
            },
            placeholder = {
                Text(text = "Name")
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = PrimaryColor,
                unfocusedIndicatorColor = BlackColor,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                cursorColor = PrimaryColor,
                focusedTextColor = PrimaryColor,
                unfocusedTextColor = BlackColor,
                selectionColors = TextSelectionColors(
                    handleColor = PrimaryColor,
                    backgroundColor = PrimaryColor.copy(alpha = 0.4f)
                )
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = userEmail.value, onValueChange = {
                userEmail.value = it
            },
            placeholder = {
                Text(text = "Email address")
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = PrimaryColor,
                unfocusedIndicatorColor = BlackColor,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                cursorColor = PrimaryColor,
                focusedTextColor = PrimaryColor,
                unfocusedTextColor = BlackColor,
                selectionColors = TextSelectionColors(
                    handleColor = PrimaryColor,
                    backgroundColor = PrimaryColor.copy(alpha = 0.4f)
                )
            )
        )


        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = userNumber.value, onValueChange = {
                userNumber.value = it
            },
            placeholder = {
                Text(text = "Phone number")
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = PrimaryColor,
                unfocusedIndicatorColor = BlackColor,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                cursorColor = PrimaryColor,
                focusedTextColor = PrimaryColor,
                unfocusedTextColor = BlackColor,
                selectionColors = TextSelectionColors(
                    handleColor = PrimaryColor,
                    backgroundColor = PrimaryColor.copy(alpha = 0.4f)
                )
            )
        )


        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = userAddress.value, onValueChange = {
                userAddress.value = it
            },
            placeholder = {
                Text(text = "Address")
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = PrimaryColor,
                unfocusedIndicatorColor = BlackColor,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                cursorColor = PrimaryColor,
                focusedTextColor = PrimaryColor,
                unfocusedTextColor = BlackColor,
                selectionColors = TextSelectionColors(
                    handleColor = PrimaryColor,
                    backgroundColor = PrimaryColor.copy(alpha = 0.4f)
                )
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = userPineCode.value, onValueChange = {
                userPineCode.value = it
            },
            placeholder = {
                Text(text = "PinCode")
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = PrimaryColor,
                unfocusedIndicatorColor = BlackColor,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                cursorColor = PrimaryColor,
                focusedTextColor = PrimaryColor,
                unfocusedTextColor = BlackColor,
                selectionColors = TextSelectionColors(
                    handleColor = PrimaryColor,
                    backgroundColor = PrimaryColor.copy(alpha = 0.4f)
                )
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = userPassword.value, onValueChange = {
                userPassword.value = it
            },
            placeholder = {
                Text(text = "Password")
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = PrimaryColor,
                unfocusedIndicatorColor = BlackColor,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                cursorColor = PrimaryColor,
                focusedTextColor = PrimaryColor,
                unfocusedTextColor = BlackColor,
                selectionColors = TextSelectionColors(
                    handleColor = PrimaryColor,
                    backgroundColor = PrimaryColor.copy(alpha = 0.4f)
                )
            )
        )


        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = repeatPassword.value, onValueChange = {
                repeatPassword.value = it
            },
            placeholder = {
                Text(text = "Re-Peat password")
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = PrimaryColor,
                unfocusedIndicatorColor = BlackColor,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                cursorColor = PrimaryColor,
                focusedTextColor = PrimaryColor,
                unfocusedTextColor = BlackColor,
                selectionColors = TextSelectionColors(
                    handleColor = PrimaryColor,
                    backgroundColor = PrimaryColor.copy(alpha = 0.4f)
                )
            )
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {

                if (userName.value.isEmpty() || userEmail.value.isEmpty() || userNumber.value.isEmpty() || userAddress.value.isEmpty() || userPineCode.value.isEmpty() || userPassword.value.isEmpty() || repeatPassword.value.isEmpty()) {

                    Toast.makeText(context, "Please fill the all details", Toast.LENGTH_SHORT)
                        .show()

                } else if (repeatPassword.value != userPassword.value) {

                    Toast.makeText(context, "Repeat password must be same", Toast.LENGTH_SHORT)
                        .show()
                } else {

                    viewModel.userCreateRes(
                        phoneInfo = getMobileInfo(),
                        name = userName.value,
                        email = userEmail.value,
                        phoneNumber = userNumber.value,
                        address = userAddress.value,
                        pinCode = userPineCode.value,
                        password = userPassword.value
                    )
                    Toast.makeText(context, "User Created Successfully", Toast.LENGTH_SHORT).show()

                    userEmail.value =""
                    userNumber.value = ""
                    userAddress.value = ""
                    userPineCode.value = ""
                    userPassword.value = ""
                    userName.value = ""
                    repeatPassword.value = ""

                }

            },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryColor
            )
        ) {
            Text(text = "Create User")
        }
    }
}


fun getMobileInfo(): String {

    return "Brand: ${Build.BRAND}" +
            "\nDevice: ${Build.DEVICE}"
}
