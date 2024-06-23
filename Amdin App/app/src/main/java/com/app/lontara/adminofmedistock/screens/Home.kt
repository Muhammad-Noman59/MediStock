package com.app.lontara.adminofmedistock.screens

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.lontara.adminofmedistock.R
import com.app.lontara.adminofmedistock.navigation.Routes
import com.app.lontara.adminofmedistock.network.UserGetResponse
import com.app.lontara.adminofmedistock.screens.viewModel.ViewModel
import com.app.lontara.adminofmedistock.ui.theme.BlackColor
import com.app.lontara.adminofmedistock.ui.theme.PrimaryColor
import com.app.lontara.adminofmedistock.ui.theme.WhiteColor


@Composable
fun Home(navHostController: NavHostController, viewModel: ViewModel) {

    val allUsers = viewModel.res.value ?: emptyList()
    val allProducts = viewModel.getAllProductRes.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(color = WhiteColor)
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = PrimaryColor
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Card(
                    modifier = Modifier
                        .padding(vertical = 12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = WhiteColor
                    ),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .width(130.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.user_icon),
                            contentDescription = "User Icon"
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "All Users",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            ),
                            color = BlackColor
                        )
                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = allUsers.size.toString(),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            color = PrimaryColor
                        )
                    }
                }


                Card(
                    modifier = Modifier
                        .padding(vertical = 12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = WhiteColor
                    ),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .width(130.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.product_icon),
                            contentDescription = "Products Icon"
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "All Products",
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            ),
                            color = BlackColor
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = allProducts.size.toString(),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            color = PrimaryColor
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            CardItems(image = R.drawable.user_icon, title = "All\nUsers", onClick = {
                navHostController.navigate(Routes.AllUsers)
            })

            CardItems(image = R.drawable.product_icon, title = "All\nProducts",
                onClick = {
                    navHostController.navigate(Routes.AllProducts)
                }
                )

            CardItems(image = R.drawable.add_product_icon, title = "Add\nProduct", onClick = {
                navHostController.navigate(Routes.AddProduct)
            })
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            CardItems(image = R.drawable.add_user_icon, title = "Add\nUser",
                onClick = {
                    navHostController.navigate(Routes.AddUser)
                })

            CardItems(image = R.drawable.pending_user_icon, title = "Pending\nUsers",
                onClick = {
                    navHostController.navigate(Routes.AllPendingUsers)
                }
                )

            CardItems(image = R.drawable.cancel_icon, title = "DisApproved\nUsers",
                onClick = {
                    navHostController.navigate(Routes.AllDisApprovedUsers)
                }
                )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            CardItems(image = R.drawable.pending_order_icon, title = "Pending\nOrders",
                onClick = {
                    navHostController.navigate(Routes.PendingOrders)
                }
                )

        }
    }
}


@Composable
fun CardItems(image: Int, title: String, onClick: () -> Unit = { Unit }) {

    Card(
        modifier = Modifier
            .clickable {
                onClick()
            }
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(5.dp),
                spotColor = BlackColor
            ),
        shape = RoundedCornerShape(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = WhiteColor
        )
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 18.dp, horizontal = 12.dp)
                .width(70.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = " Icon ",
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title,
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                ),
                textAlign = TextAlign.Center
            )
        }
    }
}