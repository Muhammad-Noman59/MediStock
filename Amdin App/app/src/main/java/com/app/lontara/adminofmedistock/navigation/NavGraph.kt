package com.app.lontara.adminofmedistock.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.app.lontara.adminofmedistock.screens.AddProduct
import com.app.lontara.adminofmedistock.screens.AddUser
import com.app.lontara.adminofmedistock.screens.AllProducts
import com.app.lontara.adminofmedistock.screens.allUsers.AllUsers
import com.app.lontara.adminofmedistock.screens.Home
import com.app.lontara.adminofmedistock.screens.PendingOrders
import com.app.lontara.adminofmedistock.screens.allUsers.AllDisApprovedUsers.AllDisApprovedUsers
import com.app.lontara.adminofmedistock.screens.allUsers.AllDisApprovedUsers.DisApprovedUserDetails
import com.app.lontara.adminofmedistock.screens.allUsers.UserDetails
import com.app.lontara.adminofmedistock.screens.allUsers.allPendingUsers.AllPendingUsers
import com.app.lontara.adminofmedistock.screens.allUsers.allPendingUsers.PendingUserDetails
import com.app.lontara.adminofmedistock.screens.viewModel.ViewModel


@Composable
fun NavGraph(navHostController: NavHostController, viewModel: ViewModel) {

    NavHost(navController = navHostController, startDestination = Routes.Home){

        composable<Routes.AllUsers> {
            AllUsers(navHostController = navHostController, viewModel = viewModel)
        }

        composable<Routes.UserDetails> { backStack->
            val data : Routes.UserDetails = backStack.toRoute()
            UserDetails(res = data, viewModel = viewModel, navHostController = navHostController)
        }

        composable<Routes.Home> {
            Home(navHostController = navHostController, viewModel = viewModel)
        }

        composable<Routes.AddProduct> {
            AddProduct(viewModel = viewModel, navHostController = navHostController)
        }

        composable<Routes.AllPendingUsers> {
            AllPendingUsers(viewModel = viewModel, navHostController = navHostController)
        }

        composable<Routes.PendingUserDetails> { backStack ->

            val pendingUserData : Routes.PendingUserDetails = backStack.toRoute()
            PendingUserDetails(
                res = pendingUserData,
                viewModel = viewModel,
                navHostController = navHostController
            )
        }


        composable<Routes.AllDisApprovedUsers> {
            AllDisApprovedUsers(viewModel = viewModel, navHostController = navHostController)
        }

        composable<Routes.DisApprovedUserDetails> { backStack ->

            val disApprovedUserData : Routes.DisApprovedUserDetails = backStack.toRoute()
            DisApprovedUserDetails(
                res = disApprovedUserData,
                viewModel = viewModel,
                navHostController = navHostController
            )
        }

        composable<Routes.PendingOrders> {
            PendingOrders(viewModel = viewModel, navHostController = navHostController)
        }

        composable<Routes.AllProducts> {
            AllProducts(viewModel = viewModel, navHostController = navHostController)
        }

        composable<Routes.AddUser> {
            AddUser(viewModel = viewModel, navHostController = navHostController)
        }
    }
}

