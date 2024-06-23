package com.app.lontara.adminofmedistock.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StatusIcon(color: Color) {

    Card(

        modifier = Modifier
            .size(5.dp),
        shape = CircleShape,
        colors = CardDefaults.cardColors(
            containerColor = color
        )

    ) {

    }
}