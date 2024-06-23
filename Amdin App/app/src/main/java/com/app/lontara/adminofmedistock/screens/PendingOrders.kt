package com.app.lontara.adminofmedistock.screens

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.lontara.adminofmedistock.R
import com.app.lontara.adminofmedistock.components.StatusIcon
import com.app.lontara.adminofmedistock.screens.viewModel.ViewModel
import com.app.lontara.adminofmedistock.ui.theme.BlackColor
import com.app.lontara.adminofmedistock.ui.theme.HintColor
import com.app.lontara.adminofmedistock.ui.theme.PrimaryColor
import com.app.lontara.adminofmedistock.ui.theme.WarningColor
import com.app.lontara.adminofmedistock.ui.theme.WhiteColor


@Composable
fun PendingOrders(viewModel: ViewModel, navHostController: NavHostController) {

    val res = viewModel.getAllOrdersDetailRes.value ?: emptyList()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
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
                text = "Pending Orders",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

        }


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            items(res) {
                PendingOrdersCard(
                    userName = it!!.user_name,
                    productName = it.product_name,
                    messages = it.message,
                    totalAmount = it.total_amount.toString(),
                    price = it.price.toString(),
                    quantity = it.quantity.toString(),
                    isApproved = it.isApproved.toString(),
                    date = it.date_of_order_creation,
                    viewModel = viewModel,
                    orderId = it.order_id,
                    category = it.category,
                    certified = it.certified,
                    userId = it.user_id,
                    stock = it.quantity.toString()
                )
            }
        }
    }
}

@Composable
fun PendingOrdersCard(
    userName: String,
    productName: String,
    messages: String,
    totalAmount: String,
    price: String,
    quantity: String,
    isApproved: String,
    date: String,
    viewModel: ViewModel,
    orderId: String,
    category: String,
    certified: String,
    userId: String,
    stock: String
) {

    val context = LocalContext.current

    val message = rememberSaveable { mutableStateOf("") }
    message.value = messages

    if (isApproved == "2") {

        Spacer(modifier = Modifier.height(8.dp))


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 10.dp,
                    spotColor = BlackColor,
                    shape = RoundedCornerShape(10.dp)
                ),
            colors = CardDefaults.cardColors(
                containerColor = WhiteColor
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "User Name:",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        color = HintColor
                    )
                    Text(
                        text = userName,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        color = BlackColor,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Product Name:",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        color = HintColor
                    )
                    Text(
                        text = productName,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        color = BlackColor,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Product Quantity:",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        color = HintColor
                    )
                    Text(
                        text = quantity,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        color = BlackColor,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Product Price:",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        color = HintColor
                    )
                    Text(
                        text = "$${price}",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        color = BlackColor,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Total Amount:",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        color = HintColor
                    )
                    Text(
                        text = "$${totalAmount}",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        color = BlackColor,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))


                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "IsApproved:",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        color = HintColor,
                        modifier = Modifier.padding(end = 4.dp)
                    )

                    StatusIcon(color = HintColor)
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Date of order creation:",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        color = HintColor
                    )
                    Text(
                        text = date,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        ),
                        color = BlackColor,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Message",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = message.value, onValueChange = {
                            message.value = it
                        },
                        placeholder = {
                            Text(text = "Write message...")
                        },
                        readOnly = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent
                        ),
                        modifier =
                        Modifier
                            .fillMaxWidth()
                            .border(
                                width = 2.dp,
                                shape = RoundedCornerShape(10.dp),
                                brush = SolidColor(PrimaryColor)
                            )
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {

                            viewModel.updateOrderDetail(
                                orderId = orderId.toString(),
                                isApproved = "0"
                            )
                            Toast.makeText(
                                context,
                                "Order DisApproved Successfully",
                                Toast.LENGTH_SHORT
                            ).show()

                        },
                        shape = RoundedCornerShape(5.dp),
                        modifier = Modifier.width(130.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = WarningColor
                        )
                    ) {
                        Text(text = "DisApproved")
                    }


                    Button(
                        onClick = {

                            viewModel.updateOrderDetail(
                                orderId = orderId,
                                isApproved = "1"
                            )

                            viewModel.addToAvailableProducts(
                                productName = productName,
                                category = category,
                                certified = certified,
                                price = price,
                                stock = stock,
                                userName = userName,
                                userId = userId.toString()
                            )

                            Toast.makeText(
                                context,
                                "Order Approved Successfully",
                                Toast.LENGTH_SHORT
                            ).show()

                        },
                        shape = RoundedCornerShape(5.dp),
                        modifier = Modifier.width(130.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PrimaryColor
                        )
                    ) {
                        Text(text = "Approved")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

    }
}