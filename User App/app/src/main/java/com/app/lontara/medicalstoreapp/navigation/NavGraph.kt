package com.app.lontara.medicalstoreapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.lontara.medicalstoreapp.R
import com.app.lontara.medicalstoreapp.components.Message
import com.app.lontara.medicalstoreapp.pref.UserData
import com.app.lontara.medicalstoreapp.screens.AvailableProducts
import com.app.lontara.medicalstoreapp.screens.SplashScreen
import com.app.lontara.medicalstoreapp.screens.home.Home
import com.app.lontara.medicalstoreapp.screens.signin.SignInScreen
import com.app.lontara.medicalstoreapp.screens.signup.SignUpScreen
import com.app.lontara.medicalstoreapp.screens.viewModel.ViewModel

@Composable
fun NavGraph(viewModel: ViewModel, navHostController: NavHostController) {

    val user = viewModel.getUserRes.value ?: emptyList()

    NavHost(navController = navHostController, startDestination = Routes.SplashScreen){

        composable<Routes.SignUpScreen> {
            SignUpScreen(viewModel = viewModel, navHostController)
        }

        composable<Routes.SignInScreen> {
            SignInScreen(viewModel = viewModel, navHostController)
        }

        composable<Routes.Message> {

            if (user.isNotEmpty()) {
                user.map {

                    if (it!!.isApproved == 2) {

                        Message(
                            title = "Account Approval Pending",
                            message = "Your account is currently under review. We are working to approve it as quickly as possible. You can check back later to see if your account has been approved.",
                            image = R.drawable.sad_image,
                            onClick = {
                            }
                        )
                    } else if (it.isApproved == 1) {
                        Message(
                            title = "Account Approved",
                            message = "Congratulations! Your account has been approved. You now have full access to all the features of Medistock. Get started by exploring the app and making the most out of our services.",
                            image = R.drawable.congratulations_image,
                            btnText = "Go to home",
                            onClick = {
                                navHostController.navigate(Routes.Home)
                                    viewModel.setUserData(
                                        listOf(
                                            UserData(
                                                userId = it.user_id,
                                                isApproved = true
                                            )
                                        )
                                    )
                            }
                        )
                    } else {
                        Message(
                            title = "Account Not Approved",
                            message = "We regret to inform you that your account has not been approved at this time. If you believe this is a mistake or need further assistance, please contact our support team.Thank you for your understanding.",
                            image = R.drawable.sad_image,
                            onClick = {
                            }
                        )
                    }
                }

            }
        }
        composable<Routes.Home> {
            Home(viewModel = viewModel, navHostController = navHostController)
        }


        composable<Routes.SplashScreen> {
            SplashScreen(viewModel = viewModel, navHostController = navHostController)
        }


        composable<Routes.AvailableProducts> {
            AvailableProducts(viewModel = viewModel, navHostController = navHostController)
        }

    }


}