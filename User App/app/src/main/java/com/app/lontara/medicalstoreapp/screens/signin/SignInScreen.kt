package com.app.lontara.medicalstoreapp.screens.signin

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.lontara.medicalstoreapp.R
import com.app.lontara.medicalstoreapp.components.bounceClick
import com.app.lontara.medicalstoreapp.navigation.Routes
import com.app.lontara.medicalstoreapp.pref.UserData
import com.app.lontara.medicalstoreapp.screens.home.Home
import com.app.lontara.medicalstoreapp.ui.theme.HintColor
import com.app.lontara.medicalstoreapp.ui.theme.PrimaryDeepBlue
import com.app.lontara.medicalstoreapp.screens.viewModel.ViewModel
import com.app.lontara.medicalstoreapp.ui.theme.LightBlue
import com.app.lontara.medicalstoreapp.ui.theme.WhiteColor


@Composable
fun SignInScreen(viewModel: ViewModel, navHostController: NavHostController) {


    val context = LocalContext.current
    var eFocused by rememberSaveable { mutableStateOf(false) }
    var passFocused by rememberSaveable { mutableStateOf(false) }
    var checkBox by rememberSaveable { mutableStateOf(false) }

    var isFocused by remember { mutableStateOf(false) }
    val focusRequester = FocusRequester()

    val userPassword = remember { mutableStateOf("") }
    val userEmail = remember { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    val padding = Modifier.padding(8.dp)


    viewModel.StatesNo(viewModel = viewModel)

    if (viewModel.goHome.value){

        LaunchedEffect(key1 = true) {
            viewModel.setUserData(
                listOf(
                    UserData(userId = viewModel.response.value!!.message)
                )
            )
        }
       Home(viewModel = viewModel, navHostController = navHostController)
    }else{

        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
                .fillMaxSize()
                .background(color = WhiteColor)
                .padding(start = 30.dp, end = 30.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Spacer(padding)

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(100.dp)
            )

            Spacer(padding)

            Text(
                text = "Welcome back to MediStock!",

                fontWeight = FontWeight.ExtraBold, fontSize = 20.sp, color = PrimaryDeepBlue
            )
            Spacer(modifier = Modifier.padding(3.dp))


            Text(
                text = "Let's get started with your\naccount login.",
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.padding(15.dp))


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start),
                contentAlignment = Alignment.CenterStart
            ) {

                Card(
                    modifier = Modifier
                        .background(color = Color.White)
                        .shadow(
                            elevation = 5.dp,
                            spotColor = if (eFocused == true) PrimaryDeepBlue else Color.Black,
                            shape = RoundedCornerShape(100)
                        ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White, disabledContainerColor = PrimaryDeepBlue
                    ),
                    shape = RoundedCornerShape(100),
                ) {
                    TextField(value = userEmail.value,
                        onValueChange = { userEmail.value = it },
                        placeholder = {
                            Text(
                                text = "Enter your email address", color = HintColor
                            )
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(100),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            cursorColor = PrimaryDeepBlue,
                            focusedLeadingIconColor = PrimaryDeepBlue,
                            focusedTextColor = PrimaryDeepBlue,
                            selectionColors = TextSelectionColors(
                                handleColor = PrimaryDeepBlue, backgroundColor = LightBlue
                            )

                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 60.dp)
                            .focusRequester(focusRequester)
                            .onFocusChanged {
                                isFocused = it.isFocused
                                if (it.isFocused) {
                                    eFocused = true
                                } else {
                                    eFocused = false
                                }
                            })
                }


                Card(

                    shape = RoundedCornerShape(100),
                    modifier = Modifier
                        .background(color = Color.Transparent)
                        .size(60.dp)
                        .shadow(
                            elevation = 5.dp,
                            spotColor = if (eFocused == true) PrimaryDeepBlue else Color.Black,
                            shape = RoundedCornerShape(100)
                        ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )

                ) {


                    Image(
                        painter = painterResource(id = R.drawable.email_icon),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(15.dp),
                        colorFilter = if (eFocused == true) ColorFilter.tint(color = PrimaryDeepBlue) else ColorFilter.tint(
                            color = Color.Black
                        ),

                        )


                }

            }

            Spacer(padding)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start),
                contentAlignment = Alignment.CenterStart
            ) {

                Card(
                    modifier = Modifier
                        .background(color = Color.White)
                        .shadow(
                            elevation = 5.dp,
                            spotColor = if (passFocused == true) PrimaryDeepBlue else Color.Black,
                            shape = RoundedCornerShape(100)
                        ),
                    colors = CardDefaults.cardColors(

                        containerColor = Color.White, disabledContainerColor = PrimaryDeepBlue

                    ),
                    shape = RoundedCornerShape(100),
                ) {
                    TextField(value = userPassword.value,
                        onValueChange = { userPassword.value = it },
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        trailingIcon = {
                            val image = if (passwordVisible) {
                                painterResource(id = R.drawable.visibility_on)
                            } else {
                                painterResource(id = R.drawable.visibility_off)
                            }

                            val description = if (passwordVisible) "Hide Password" else "Show Password"

                            Image(
                                painter = image, contentDescription = description,
                                modifier = Modifier.clickable {
                                    passwordVisible = !passwordVisible
                                },
                                colorFilter = ColorFilter.tint(if (passFocused) PrimaryDeepBlue else Color.Black)
                            )
                        },
                        placeholder = {
                            Text(
                                text = "Enter your password", color = HintColor
                            )
                        },
                        singleLine = true,
                        shape = RoundedCornerShape(100),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            cursorColor = PrimaryDeepBlue,
                            focusedLeadingIconColor = PrimaryDeepBlue,
                            focusedTextColor = PrimaryDeepBlue,
                            selectionColors = TextSelectionColors(
                                handleColor = PrimaryDeepBlue, backgroundColor = LightBlue
                            )

                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 60.dp)
                            .focusRequester(focusRequester)
                            .onFocusChanged {
                                isFocused = it.isFocused
                                if (it.isFocused) {
                                    passFocused = true
                                } else {
                                    passFocused = false
                                }
                            })
                }


                Card(

                    shape = RoundedCornerShape(100),
                    modifier = Modifier
                        .background(color = Color.Transparent)
                        .size(60.dp)
                        .shadow(
                            elevation = 5.dp,
                            spotColor = if (passFocused == true) PrimaryDeepBlue else Color.Black,
                            shape = RoundedCornerShape(100)
                        ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )

                ) {


                    Image(
                        painter = painterResource(id = R.drawable.password_icon),
                        contentDescription = "",
                        colorFilter = if (passFocused == true) ColorFilter.tint(color = PrimaryDeepBlue) else ColorFilter.tint(
                            color = Color.Black
                        ),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(15.dp),

                        )


                }

            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checkBox,
                        onCheckedChange = {
                            checkBox = it
                        },
                        colors =CheckboxDefaults.colors(
                            checkedColor = PrimaryDeepBlue
                        )
                    )
                    Text(text = "Remember me",
                        style = TextStyle(
                            fontSize = 12.sp
                        ))
                }

                Text(text = "Forgot password?",
                    color = Color.Red,
                    style = TextStyle(
                        fontSize = 12.sp
                    )
                )


            }

            Spacer(modifier = Modifier.height(16.dp))

            ElevatedButton(
                onClick = {

                    if (userEmail.value.isEmpty() || userPassword.value.isEmpty()) {
                        Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                    }else{
                        viewModel.loginUser(
                            email = userEmail.value,
                            password = userPassword.value
                        )
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .bounceClick(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryDeepBlue
                ),
                shape = RoundedCornerShape(corner = CornerSize(10.dp))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    if (viewModel.loading.value) {
                        CircularProgressIndicator(
                            color = Color.White,
                            strokeWidth = 2.dp,
                            modifier = Modifier
                                .size(35.dp)
                                .padding(10.dp)
                        )
                    }else{
                        Text(
                            text = "Log In"
                        )
                    }

                }
            }

            Spacer(padding)

            Row(
                modifier = Modifier.clickable {
                    navHostController.navigate(Routes.SignUpScreen)

                }
            ) {
                Text(text = "Don't have an account?")
                Text(
                    text = " SignUp", color = PrimaryDeepBlue
                )
            }
        }
    }




}