package com.app.lontara.adminofmedistock.screens.allUsers.AllDisApprovedUsers

import android.widget.Toast
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.lontara.adminofmedistock.R
import com.app.lontara.adminofmedistock.components.StatusIcon
import com.app.lontara.adminofmedistock.navigation.Routes.DisApprovedUserDetails
import com.app.lontara.adminofmedistock.screens.viewModel.ViewModel
import com.app.lontara.adminofmedistock.ui.theme.BlackColor
import com.app.lontara.adminofmedistock.ui.theme.HintColor
import com.app.lontara.adminofmedistock.ui.theme.PrimaryColor
import com.app.lontara.adminofmedistock.ui.theme.WarningColor
import com.app.lontara.adminofmedistock.ui.theme.WhiteColor


@Composable
fun DisApprovedUserDetails(res: DisApprovedUserDetails, viewModel: ViewModel, navHostController: NavHostController) {

    val context = LocalContext.current

    var phoneInfo by remember { mutableStateOf(false) }

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
                text = res.name,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = PrimaryColor
            )
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = WhiteColor
                )
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(start = 8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = res.name,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
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
                                        modifier = Modifier.padding(start = 12.dp),
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

                                        StatusIcon(color = HintColor)

                                    }
                                }
                            }


                        }
                        Image(
                            painter = painterResource(id = R.drawable.edit_icon),
                            contentDescription = " Edit Icon",
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Email:",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            color = HintColor
                        )

                        Text(
                            text = res.email,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
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
                            text = "Number:",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            color = HintColor
                        )

                        Text(
                            text = res.phone,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
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
                            text = "Password:",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            color = HintColor
                        )

                        Text(
                            text = res.password,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
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
                            text = "Address:",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            color = HintColor
                        )

                        Text(
                            text = res.address,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
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
                            text = "PinCode:",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            color = HintColor
                        )

                        Text(
                            text = res.pinCode,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
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
                            text = "Date of account creation:",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            color = HintColor
                        )

                        Text(
                            text = res.date_of_account_creation,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
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
                            text = "Level:",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            color = HintColor
                        )

                        Text(
                            text = res.level.toString(),
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
                            ),
                            color = BlackColor,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                        Button(
                            onClick = {
                                viewModel.updateUser(
                                    approved = 1,
                                    userId = res.user_id
                                )

                                Toast.makeText(
                                    context,
                                    "User Approved Successfully",
                                    Toast.LENGTH_SHORT
                                ).show()

                            },
                            shape = RoundedCornerShape(5.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .width(130.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = PrimaryColor
                            )
                        ) {
                            Text(text = "Approved")
                        }
                    }

            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier
                    .clickable {
                        phoneInfo = !phoneInfo
                    }
                    .shadow(
                        elevation = 10.dp,
                        shape = RoundedCornerShape(5.dp),
                        spotColor = BlackColor
                    ),
                shape = RoundedCornerShape(5.dp),
                colors = CardDefaults.cardColors(
                    containerColor = WhiteColor
                ),
            ) {
                Column(
                    modifier = Modifier.padding(18.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.mobile_icon),
                        contentDescription = " Mobile Icon ",
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Device Details",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        if (phoneInfo){
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(
                        elevation = 5.dp,
                        spotColor = BlackColor,
                        shape = RoundedCornerShape(5.dp)
                    ),
                colors = CardDefaults.cardColors(
                    containerColor = WhiteColor
                ),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    text = res.phoneInfo,
                    style = TextStyle(
                        fontSize = 16.sp
                    ),
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

    }
}
