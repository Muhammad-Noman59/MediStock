package com.app.lontara.medicalstoreapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.lontara.medicalstoreapp.screens.viewModel.ViewModel
import com.app.lontara.medicalstoreapp.ui.theme.PrimaryDeepBlue


@Composable
fun Message(
  title: String? = null, message: String? = null, btnText: String? = null, image : Int? = null, onClick: () -> Unit
) {




    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if(image != null) {

            Image(
                painter = painterResource(id = image),
                contentDescription = "Message Image",
                modifier = Modifier.size(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
        }


        Text(
            text = title!!,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal
            ),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = message!!,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            ),
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        if (btnText != null) {

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            onClick()
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryDeepBlue
            ),
            modifier = Modifier.fillMaxWidth()) {

            Text(text = btnText)
        }
        }
    }
}

