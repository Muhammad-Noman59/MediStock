package com.app.lontara.medicalstoreapp.screens.home

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.navigation.NavHostController
import com.app.lontara.medicalstoreapp.R
import com.app.lontara.medicalstoreapp.components.bounceClick
import com.app.lontara.medicalstoreapp.navigation.Routes
import com.app.lontara.medicalstoreapp.pref.UserData
import com.app.lontara.medicalstoreapp.screens.viewModel.ViewModel
import com.app.lontara.medicalstoreapp.ui.theme.BlackColor
import com.app.lontara.medicalstoreapp.ui.theme.HintColor
import com.app.lontara.medicalstoreapp.ui.theme.PrimaryDeepBlue
import com.app.lontara.medicalstoreapp.ui.theme.SuccessColor
import com.app.lontara.medicalstoreapp.ui.theme.WarningColor
import com.app.lontara.medicalstoreapp.ui.theme.WhiteColor

@Composable
fun DashBoard (viewModel: ViewModel, navHostController: NavHostController){

    val availableProducts = viewModel.getAvailableProductsByUserIdRes.value ?: emptyList()
    val sellHistory = viewModel.getSellHistoryRes.value ?: emptyList()

    val totalSell = sellHistory.sumOf { it!!.total_amount }

    val context = LocalContext.current

    val userName = rememberSaveable { mutableStateOf("") }
    val dataFromDatastore = viewModel.userListState.collectAsState()
    val userId = rememberSaveable{ mutableStateOf("") }
    var availablePro by rememberSaveable { mutableStateOf(false) }

    dataFromDatastore.value.map {
        userId.value = it.userId!!
        if(it.name == null){
            userName.value = "..."
        }else{
            userName.value = it.name
        }
    }


    availableProducts.map {
        if (it.stock == 0){
            availablePro = true
        }
    }

    val productName = rememberSaveable { mutableStateOf("") }
    val availableStock = rememberSaveable { mutableStateOf("1") }
    val category = rememberSaveable { mutableStateOf("") }
    val certified = rememberSaveable { mutableIntStateOf(0) }
    val productId = rememberSaveable { mutableStateOf("") }
    val quantity = rememberSaveable { mutableStateOf("1") }
    val price = rememberSaveable { mutableStateOf(0.0) }
    val totalAmount = rememberSaveable { mutableStateOf(0.0) }
    var dropDown by rememberSaveable { mutableStateOf(false) }



    val userDataFromApi = viewModel.getUserRes.value ?: null
    userDataFromApi!!.map {
        viewModel.setUserData(
            listOf(
                UserData(
                    name = it!!.name,
                    email = it.email,
                    password = it.password,
                    userId = it.user_id,
                    address = it.address,
                    pinCode = it.pinCode,
                    phoneNumber = it.phone_number,
                    isApproved = true
                )
            )
        )
    }


    Column(
        modifier = Modifier
            .verticalScroll(state = rememberScrollState())
            .fillMaxSize()
            .padding(8.dp)
            .background(color = WhiteColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "\uD83D\uDC4B Hello, ${userName.value}"
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = PrimaryDeepBlue
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Card(
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .clickable {
                            navHostController.navigate(Routes.AvailableProducts)
                        },
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
                            contentDescription = "Product Icon",
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "All Products",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium
                            ),
                            color = BlackColor
                        )
                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = if (availablePro) "0" else availableProducts.size.toString(),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            color = PrimaryDeepBlue
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
                            painter = painterResource(id = R.drawable.dollar_icon),
                            contentDescription = "Dollar Icon",
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Total Sell",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium
                            ),
                            color = BlackColor
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "$${totalSell}",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            color = PrimaryDeepBlue
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))


        if (productName.value != "") {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 10.dp,
                        spotColor = BlackColor,
                        shape = RoundedCornerShape(10.dp)
                    ),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = WhiteColor
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp, horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = productName.value,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )

                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Category:",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Normal
                                ),
                                color = HintColor
                            )
                            Text(
                                text = category.value,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium
                                ),
                                color = BlackColor,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Price: ",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Normal
                                ),
                                color = HintColor,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                            Text(
                                text = "$${price.value}",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium
                                ),
                                color = BlackColor
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Available Stock:",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Normal
                                ),
                                color = HintColor
                            )
                            Text(
                                text = availableStock.value,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium
                                ),
                                color = BlackColor,
                                modifier = Modifier.padding(start = 4.dp)
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Certified:",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Normal
                                ),
                                color = HintColor
                            )
                            Box(
                                modifier = Modifier
                                    .padding(start = 4.dp)
                                    .background(
                                        color = if (certified.value == 0) WarningColor else SuccessColor,
                                        shape = CircleShape
                                    )
                                    .size(10.dp)
                                    .clip(
                                        shape = CircleShape
                                    )
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        Column(
        ) {
            OutlinedTextField(
                value = productName.value, onValueChange = {
                    productName.value = it
                },
                readOnly = true,
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.drop_down_icon),
                        contentDescription = " Drop Down Icon",
                        colorFilter = ColorFilter.tint(color = PrimaryDeepBlue),
                        modifier = Modifier
                            .rotate(
                                if (dropDown) 180f else 0f
                            )
                            .size(40.dp)
                            .padding(horizontal = 8.dp)
                            .clickable {
                                dropDown = true
                            }
                    )
                },
                placeholder = {
                    Text(text = "Please select product name")
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 2.dp,
                        shape = RoundedCornerShape(10.dp),
                        brush = SolidColor(PrimaryDeepBlue)
                    )
            )

            DropdownMenu(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White),
                expanded = dropDown, onDismissRequest = {
                    dropDown = false
                }) {
                availableProducts.forEach {
                    DropdownMenuItem(
                        text = {
                            Text(text = it.product_name)
                        },
                        onClick = {
                            productName.value = it.product_name
                            category.value = it.category
                            price.value = it.price
                            availableStock.value = it.stock.toString()
                            certified.value = it.certified
                            productId.value = it.product_id
                            dropDown = false
                        })
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Quantity",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .clickable {
                            if (quantity.value.toInt() > 1) {
                                var miniSt = quantity.value.toInt()
                                miniSt--
                                quantity.value = miniSt.toString()
                            }
                        }
                        .size(32.dp)
                        .background(color = Color.White, shape = CircleShape)
                        .clip(
                            shape = CircleShape,
                        )
                        .shadow(
                            elevation = 1.dp,
                            spotColor = Color.Black,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.minimize_icon),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )

                }

                Text(
                    text = quantity.value,
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            shape = RoundedCornerShape(1.dp),
                            brush = SolidColor(Color.Black)
                        )
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )

                Box(
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .clickable {
                            val mi = quantity.value.toInt()
                            if (mi > 0) {
                                var plusSt = quantity.value.toInt()
                                plusSt++
                                quantity.value = plusSt.toString()
                            }
                        }
                        .size(32.dp)
                        .background(color = Color.White, shape = CircleShape)
                        .clip(
                            shape = CircleShape,
                        )
                        .shadow(
                            elevation = 1.dp,
                            spotColor = Color.Black,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.puls_icon),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )

                }
            }


        }

        Spacer(modifier = Modifier.height(16.dp))

        val list = listOf("100", "250", "500", "750", "1000")
        var selectedIndex by rememberSaveable { mutableStateOf(7) }

        ScrollableTabRow(

            edgePadding = 0.dp,
            modifier = Modifier.fillMaxWidth(),
            containerColor = Color.White,
            divider = {},
            indicator = {},
            selectedTabIndex = selectedIndex
        ) {

            list.forEachIndexed { index, quantitys ->

                Tab(
                    selectedContentColor = PrimaryDeepBlue,
                    unselectedContentColor = Color.White,

                    selected = selectedIndex == index,
                    onClick = {
                        selectedIndex = index

                        val selectedQuantity = when (quantitys) {
                            "100" -> "100"
                            "250" -> "250"
                            "500" -> "500"
                            "750" -> "750"
                            "1000" -> "1000"
                            else -> "1"
                        }

                        quantity.value = selectedQuantity
                    }
                ) {
                    if (selectedIndex == index) {

                        Card(
                            modifier = Modifier
                                .width(130.dp)
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
                                    text = quantitys,
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
                                .width(130.dp)
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
                                    text = quantitys,
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

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "1 Product",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
            )

            Text(
                text = "$${price.value}",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        totalAmount.value = price.value * quantity.value.toInt()

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Total Amount",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium
                )
            )

            Text(
                text = "$${totalAmount.value}",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        val remainingStock = availableStock.value.toInt() - quantity.value.toInt()
        if (quantity.value.toInt() > availableStock.value.toInt()) {

            Text(
                text = "Please choose quantity according available stock: you have choose ${quantity.value} but available stock ${availableStock.value}",
                color = WarningColor
            )
        }

        Button(
            onClick = {

                viewModel.updateAvailableProduct(
                    productId = productId.value,
                    stock = remainingStock
                )

                viewModel.createSellHistories(
                    productId = productId.value,
                    quantity = quantity.value,
                    remainingStock = remainingStock.toString(),
                    totalAmount = totalAmount.value.toString(),
                    price = price.value.toString(),
                    productName = productName.value,
                    userId = userId.value,
                    userName = userName.value
                )

                quantity.value = "1"
                totalAmount.value = 0.0
                price.value = 0.0
                productName.value = ""

                Toast.makeText(context, "Sale Successfully", Toast.LENGTH_SHORT)
                    .show()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryDeepBlue
            ),
            modifier = Modifier.fillMaxWidth()
                .bounceClick(),
        ) {

            Text(text = "Sell")
        }

    }
}