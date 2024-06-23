package com.app.lontara.medicalstoreapp.screens.home.orders

import android.os.Message
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.lontara.medicalstoreapp.screens.viewModel.ViewModel
import com.app.lontara.medicalstoreapp.ui.theme.BlackColor
import com.app.lontara.medicalstoreapp.ui.theme.HintColor
import com.app.lontara.medicalstoreapp.ui.theme.PrimaryDeepBlue
import com.app.lontara.medicalstoreapp.ui.theme.SuccessColor
import com.app.lontara.medicalstoreapp.ui.theme.WhiteColor


@Composable
fun Pending(viewModel: ViewModel) {

    val res = viewModel.pendingOrders.value ?: emptyList()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(res) {
            PendingOrderCard(
                name = it!!.product_name,
                quantity = it.quantity.toString(),
                totalAmount =it.total_amount.toString(),
                messages =it.message,
                date = it.date_of_order_creation
            )
        }
    }

}


@Composable
private fun PendingOrderCard(
    name: String,
    quantity: String,
    totalAmount: String,
    messages: String,
    date : String
) {

    Spacer(modifier = Modifier.height(8.dp))
    val message = rememberSaveable { mutableStateOf("") }

    message.value = messages

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
                    text = "Name:",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    color = HintColor
                )
                Text(
                    text = name,
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
                    text = "Quantity:",
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
                    text = "Order Date:",
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

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "IsApproved:",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    color = HintColor
                )
                Box(
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .background(color = HintColor, shape = CircleShape)
                        .size(10.dp)
                        .clip(
                            shape = CircleShape
                        )
                )
            }

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
                            brush = SolidColor(PrimaryDeepBlue)
                        )
                )
            }
        }
    }

    Spacer(modifier = Modifier.height(8.dp))


}