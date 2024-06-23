package com.app.lontara.medicalstoreapp.screens.home

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.lontara.medicalstoreapp.screens.viewModel.ViewModel
import com.app.lontara.medicalstoreapp.ui.theme.BlackColor
import com.app.lontara.medicalstoreapp.ui.theme.HintColor
import com.app.lontara.medicalstoreapp.ui.theme.SuccessColor
import com.app.lontara.medicalstoreapp.ui.theme.WhiteColor


@Composable
fun Sell (viewModel: ViewModel){

    val res = viewModel.getSellHistoryRes.value ?: emptyList()

    val dataFromDatastore = viewModel.userListState.collectAsState()
    val userName = rememberSaveable { mutableStateOf("") }

    dataFromDatastore.value.map {
        userName.value = it.name!!
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "\uD83D\uDC4B Hello, ${userName.value}",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn (
            modifier = Modifier.fillMaxSize()
        ){
            items(res){
                SellHistoryCard(
                    productName = it!!.product_name,
                    quantity = it.quantity.toString(),
                    date = it.date_of_sell,
                    totalAmount = it.total_amount.toString(),
                    remainingStock = it.remaining_stock.toString()
                )
            }
        }

    }
}

@Composable
fun SellHistoryCard(
    productName : String,
    quantity : String,
    date : String,
    totalAmount : String,
    remainingStock : String
){



        Spacer(modifier = Modifier.height(8.dp))

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
                    text = productName,
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
                            text = "Quantity: ",
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

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Total Amount: ",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            color = HintColor,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                        Text(
                            text = "$${totalAmount}",
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
                            text = "Date: ",
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

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Reaming Stock: ",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            color = HintColor
                        )

                        Text(
                            text = remainingStock,
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            ),
                            color = BlackColor,
                            modifier = Modifier.padding(start = 4.dp)
                        )

                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))




}