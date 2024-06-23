package com.app.lontara.medicalstoreapp.screens.home.orders

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.lontara.medicalstoreapp.R
import com.app.lontara.medicalstoreapp.screens.viewModel.ViewModel
import com.app.lontara.medicalstoreapp.ui.theme.BlackColor
import com.app.lontara.medicalstoreapp.ui.theme.HintColor
import com.app.lontara.medicalstoreapp.ui.theme.PrimaryDeepBlue
import com.app.lontara.medicalstoreapp.ui.theme.SuccessColor
import com.app.lontara.medicalstoreapp.ui.theme.WhiteColor


@Composable
fun Orders(viewModel: ViewModel) {


    val ordersState = rememberSaveable { mutableStateOf(OrdersState.NEW_ORDER.routes) }

    val orderStateList = listOf("New Order", "Pending", "Approved", "DisApproved")
    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }

    val userName = rememberSaveable { mutableStateOf("") }
    val dataFromDatastore = viewModel.userListState.collectAsState()

    dataFromDatastore.value.map {
        userName.value = it.name!!
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "\uD83D\uDC4B Hello, ${userName.value}"
        )
        Spacer(modifier = Modifier.height(16.dp))

        ScrollableTabRow(
            edgePadding = 0.dp,
            modifier = Modifier.fillMaxWidth(),
            containerColor = Color.White,
            divider = {},
            indicator = {},
            selectedTabIndex = selectedIndex
        ) {
            orderStateList.forEachIndexed { index, title ->

                Tab(selected = selectedIndex == index,
                    onClick = {
                        selectedIndex = index

                        when (title) {
                            "New Order" -> {
                                ordersState.value = OrdersState.NEW_ORDER.routes
                            }

                            "Pending" -> {
                                ordersState.value = OrdersState.PENDING.routes
                            }

                            "Approved" -> {
                                ordersState.value = OrdersState.APPROVED.routes
                            }

                            "DisApproved" -> {
                                ordersState.value = OrdersState.DISAPPROVED.routes
                            }
                        }
                    })
                {
                    if (selectedIndex == index) {

                        Card(
                            modifier = Modifier
                                .width(150.dp)
                                .height(38.dp)
                                .padding(horizontal = 8.dp),
                            shape = CircleShape,
                            colors = CardDefaults.cardColors(
                                containerColor = PrimaryDeepBlue,
                                contentColor = Color.White
                            )
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),

                                contentAlignment = Alignment.Center

                            ) {

                                Text(
                                    text = title,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                )
                            }
                        }
                    } else {
                        Card(
                            modifier = Modifier
                                .width(150.dp)
                                .height(38.dp)
                                .padding(horizontal = 8.dp)
                                .border(
                                    width = 2.dp,
                                    brush = SolidColor(PrimaryDeepBlue),
                                    shape = CircleShape
                                ),
                            shape = CircleShape,
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Transparent,
                                contentColor = Color.Gray
                            )
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center

                            ) {

                                Text(
                                    text = title,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                )
                            }
                        }
                    }
                }
            }

        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp, start = 8.dp, end = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (ordersState.value) {

                OrdersState.NEW_ORDER.routes -> {
                    NewOrder(viewModel = viewModel)
                }

                OrdersState.PENDING.routes -> {
                    Pending(viewModel = viewModel)
                }

                OrdersState.APPROVED.routes -> {
                    Approved(viewModel = viewModel)
                }

                OrdersState.DISAPPROVED.routes -> {
                    DisApproved(viewModel = viewModel)
                }
            }

        }
    }


}