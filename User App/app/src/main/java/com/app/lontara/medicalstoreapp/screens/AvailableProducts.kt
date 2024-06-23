package com.app.lontara.medicalstoreapp.screens

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.lontara.medicalstoreapp.R
import com.app.lontara.medicalstoreapp.screens.viewModel.ViewModel
import com.app.lontara.medicalstoreapp.ui.theme.BlackColor
import com.app.lontara.medicalstoreapp.ui.theme.HintColor
import com.app.lontara.medicalstoreapp.ui.theme.SuccessColor
import com.app.lontara.medicalstoreapp.ui.theme.WarningColor
import com.app.lontara.medicalstoreapp.ui.theme.WhiteColor

@Composable
fun AvailableProducts(viewModel: ViewModel, navHostController: NavHostController) {

    val res = viewModel.getAvailableProductsByUserIdRes.value ?: emptyList()
    var availablePro by rememberSaveable { mutableStateOf(false) }

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
                text = "Available Products",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

        }


        res.map {
            if (it.stock == 0) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "No available products")
                }
            } else {

                availablePro = true
            }
        }

        if (availablePro) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                items(res) {

                    AvailableProductCard(
                        productName = it.product_name,
                        availableStock = it.stock.toString(),
                        certified = it.certified.toString(),
                        price = it.price.toString(),
                        category = it.category
                    )
                }
            }
        }
    }

}


@Composable
fun AvailableProductCard(
    productName: String,
    availableStock: String,
    certified: String,
    price: String,
    category: String
) {

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
                        text = "Category:",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        color = HintColor
                    )
                    Text(
                        text = category,
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
                        text = "$${price}",
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
                        text = availableStock,
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
                                color = if (certified == "0") WarningColor else SuccessColor,
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

    Spacer(modifier = Modifier.height(8.dp))


}
