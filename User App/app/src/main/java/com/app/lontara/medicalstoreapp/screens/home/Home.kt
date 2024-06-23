package com.app.lontara.medicalstoreapp.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.app.lontara.medicalstoreapp.R
import com.app.lontara.medicalstoreapp.navigation.BottomTabs
import com.app.lontara.medicalstoreapp.screens.home.orders.Orders
import com.app.lontara.medicalstoreapp.screens.viewModel.ViewModel
import com.app.lontara.medicalstoreapp.ui.theme.PrimaryDeepBlue


@Composable
fun Home(viewModel: ViewModel, navHostController: NavHostController) {


    var dashBoard by rememberSaveable { mutableStateOf(true) }
    var sell by rememberSaveable { mutableStateOf(false) }
    var orders by rememberSaveable { mutableStateOf(false) }
    var account by rememberSaveable { mutableStateOf(false) }

    val bottomTabs = rememberSaveable { mutableStateOf(BottomTabs.DASHBOARD.route) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.90f)
                .background(color = Color.White)
        ) {
            when(bottomTabs.value){
                BottomTabs.DASHBOARD.route ->{
                    DashBoard(viewModel = viewModel, navHostController = navHostController)
                }
                BottomTabs.SELL.route ->{
                    Sell(viewModel = viewModel)
                }
                BottomTabs.ORDERS.route ->{
                    Orders(viewModel = viewModel)
                }
                BottomTabs.PROFILE.route ->{

                    val userDataFromDatastore = viewModel.userListState.collectAsState()



                    userDataFromDatastore.value.map {

                        Profile(viewModel = viewModel, user = it)
                    }
                }
                else->{

                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f)
                .clip(
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                )
        ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable {
                            bottomTabs.value = BottomTabs.DASHBOARD.route
                            dashBoard = true
                            sell = false
                            orders = false
                            account = false
                        }
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.dashboard_icon),
                            contentDescription = "DashBoard Icon",
                            colorFilter = ColorFilter.tint(color = if (dashBoard) PrimaryDeepBlue else Color.Black),
                            modifier = Modifier.size(42.dp),
                            contentScale = ContentScale.Crop
                        )
                        if (dashBoard) {
                            Text(
                                text = "DashBoard",
                                color = PrimaryDeepBlue
                            )
                        }
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable {
                            bottomTabs.value = BottomTabs.SELL.route
                            dashBoard = false
                            sell = true
                            orders = false
                            account = false
                        }
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.dollar_icon),
                            contentDescription = "Dollar Icon",
                            colorFilter = ColorFilter.tint(color = if (sell) PrimaryDeepBlue else Color.Black),
                            modifier = Modifier.size(42.dp),
                            contentScale = ContentScale.Crop
                        )

                        if (sell) {
                            Text(
                                text = "Sale History",
                                color = PrimaryDeepBlue
                            )
                        }
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable {
                            bottomTabs.value = BottomTabs.ORDERS.route
                            dashBoard = false
                            sell = false
                            orders = true
                            account = false
                        }
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.cart_icon),
                            contentDescription = "Cart Icon",
                            colorFilter = ColorFilter.tint(color = if (orders) PrimaryDeepBlue else Color.Black),
                            modifier = Modifier.size(42.dp),
                            contentScale = ContentScale.Crop
                        )
                        if (orders) {

                            Text(
                                text = "Orders",
                                color = PrimaryDeepBlue
                            )
                        }
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable {
                            bottomTabs.value = BottomTabs.PROFILE.route
                            dashBoard = false
                            sell = false
                            orders = false
                            account = true
                        }
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.profile_icon),
                            contentDescription = "Account Icon",
                            colorFilter = ColorFilter.tint(color = if (account) PrimaryDeepBlue else Color.Black),
                            modifier = Modifier.size(42.dp),
                            contentScale = ContentScale.Crop
                        )
                        if (account) {
                            Text(
                                text = "My Account",
                                color = PrimaryDeepBlue
                            )
                        }
                    }

                }
        }
    }

}
