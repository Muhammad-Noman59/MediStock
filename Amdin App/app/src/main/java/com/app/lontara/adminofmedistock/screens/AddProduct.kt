package com.app.lontara.adminofmedistock.screens

import android.content.Context
import android.util.Log
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.lontara.adminofmedistock.R
import com.app.lontara.adminofmedistock.screens.viewModel.ViewModel
import com.app.lontara.adminofmedistock.ui.theme.BlackColor
import com.app.lontara.adminofmedistock.ui.theme.PrimaryColor
import com.app.lontara.adminofmedistock.ui.theme.WhiteColor


@Composable
fun AddProduct(viewModel: ViewModel, navHostController: NavHostController) {



    val name = rememberSaveable { mutableStateOf("") }
    val price = rememberSaveable { mutableStateOf("") }
    var checkCertified by rememberSaveable { mutableStateOf(false) }
    val stock = rememberSaveable { mutableStateOf("1") }

    val category = rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 8.dp)
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
                text = "Add Product",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        OutlinedTextField(
            value = name.value,
            onValueChange = {
                name.value = it
            },
            placeholder = {
                Text(text = "Enter product name")
            },
            shape = CircleShape,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = PrimaryColor,
                unfocusedBorderColor = BlackColor,
                focusedTextColor = PrimaryColor,
                unfocusedTextColor = BlackColor,
                cursorColor = PrimaryColor,


                ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = price.value,
            onValueChange = {
                price.value = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = {
                Text(text = "Enter product price")
            },
            shape = CircleShape,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = PrimaryColor,
                unfocusedBorderColor = BlackColor,
                focusedTextColor = PrimaryColor,
                unfocusedTextColor = BlackColor,
                cursorColor = PrimaryColor,


                ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        val listOfCategory = listOf(
            "Antivirals",
            "Anxiolytics",
            "Bipolar agents",
            "Antibacterials",
            "Anticonvulsants"
        )
        var isExpend by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = category.value,
                onValueChange = {
                    category.value = it
                },
                placeholder = {
                    Text(text = "Select category")
                },

                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.drop_down_icon),
                        contentDescription = "Drop Down Icon",
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .clickable {
                                isExpend = !isExpend
                            }
                            .rotate(
                                if (isExpend) 180f else 0f
                            )
                    )
                },
                readOnly = true,
                shape = CircleShape,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = PrimaryColor,
                    unfocusedBorderColor = BlackColor,
                    focusedTextColor = PrimaryColor,
                    unfocusedTextColor = BlackColor,
                    cursorColor = PrimaryColor,
                    unfocusedTrailingIconColor = BlackColor,
                    focusedTrailingIconColor = PrimaryColor

                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            DropdownMenu(
                expanded = isExpend,
                onDismissRequest = {
                    isExpend = false
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = WhiteColor)
            ) {

                listOfCategory.forEach { categoryOption ->

                    DropdownMenuItem(
                        text = {
                            Text(
                                text = categoryOption
                            )
                        },
                        onClick = {
                            category.value = categoryOption
                            isExpend = false
                        })
                }

            }

        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checkCertified,
                    onCheckedChange = {
                        checkCertified = it
                    },
                    colors = CheckboxDefaults.colors(
                        uncheckedColor = BlackColor,
                        checkedColor = PrimaryColor
                    )
                )

                Text(
                    text = "Certified product",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                )

            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .clickable {
                            if (stock.value.toInt() > 1) {
                                var miniSt = stock.value.toInt()
                                miniSt--
                                stock.value = miniSt.toString()
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
                    text = stock.value,
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
                            val mi = stock.value.toInt()
                            if (mi > 0) {
                                var plusSt = stock.value.toInt()
                                plusSt++
                                stock.value = plusSt.toString()
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
                    selectedContentColor = PrimaryColor,
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

                        stock.value = selectedQuantity
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
                                containerColor = PrimaryColor,
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
                                    brush = SolidColor(PrimaryColor),
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

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {


                if (name.value.isEmpty() || price.value.isEmpty() || stock.value.isEmpty() || category.value.isEmpty()) {


                    Toast.makeText(
                        context,
                        "Please fill the all details",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else {

                    viewModel.addPro(
                        name = name.value,
                        price = price.value,
                        stock = stock.value,
                        certified = if (checkCertified) 1 else 0,
                        category = category.value
                    )
                    name.value = ""
                    price.value = ""
                    stock.value = ""
                    category.value = ""
                    checkCertified = false
                    Toast.makeText(context, "Product Added Successfully", Toast.LENGTH_SHORT).show()
                }

            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryColor
            )
        ) {

            Text(text = "Add product")
        }

    }

}