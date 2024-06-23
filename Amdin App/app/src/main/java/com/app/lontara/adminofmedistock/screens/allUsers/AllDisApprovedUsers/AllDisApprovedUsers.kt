package com.app.lontara.adminofmedistock.screens.allUsers.AllDisApprovedUsers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.lontara.adminofmedistock.R
import com.app.lontara.adminofmedistock.components.StatusIcon
import com.app.lontara.adminofmedistock.navigation.Routes
import com.app.lontara.adminofmedistock.network.UserGetResponse
import com.app.lontara.adminofmedistock.screens.viewModel.ViewModel
import com.app.lontara.adminofmedistock.ui.theme.BlackColor
import com.app.lontara.adminofmedistock.ui.theme.HintColor
import com.app.lontara.adminofmedistock.ui.theme.PrimaryColor
import com.app.lontara.adminofmedistock.ui.theme.SuccessColor
import com.app.lontara.adminofmedistock.ui.theme.WarningColor
import com.app.lontara.adminofmedistock.ui.theme.WhiteColor

@Composable
fun AllDisApprovedUsers(navHostController: NavHostController, viewModel: ViewModel) {

    val res = viewModel.res.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(color = WhiteColor)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
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
                text = "All DisApproved Users",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(res!!) { item ->
                ShowDisApprovedUsersCard(res = item, navHostController = navHostController)
            }
        }
    }
}


@Composable
fun ShowDisApprovedUsersCard(res: UserGetResponse, navHostController: NavHostController) {

    if (res.isApproved == 0) {

        Card(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .clickable {
                    navHostController.navigate(
                        Routes.DisApprovedUserDetails(
                            address = res.address,
                            approved = res.isApproved,
                            block = res.block,
                            date_of_account_creation = res.date_of_account_creation,
                            phoneInfo = res.phone_info,
                            email = res.email,
                            id = res.id,
                            level = res.level,
                            name = res.name,
                            password = res.password,
                            phone = res.phone_number,
                            pinCode = res.pinCode,
                            user_id = res.user_id
                        )
                    )
                }
                .fillMaxWidth()
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(10.dp),
                    spotColor = Color.Black
                ),
            colors = CardDefaults.cardColors(
                containerColor = WhiteColor
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Account status",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            color = HintColor,
                            modifier = Modifier.padding(end = 4.dp)
                        )

                            StatusIcon(color = WarningColor)

                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Block status",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            color = HintColor,
                            modifier = Modifier.padding(end = 4.dp)
                        )


                            StatusIcon(color = WarningColor)

                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = res.name,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        color = BlackColor
                    )

                    Text(
                        text = res.phone_number,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        color = BlackColor
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = res.email,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        color = BlackColor
                    )

                    Text(
                        text = res.date_of_account_creation,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        color = BlackColor
                    )
                }
            }
        }

    }

}


