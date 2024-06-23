package com.app.lontara.adminofmedistock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.app.lontara.adminofmedistock.navigation.NavGraph
import com.app.lontara.adminofmedistock.screens.viewModel.ViewModel
import com.app.lontara.adminofmedistock.ui.theme.AdminOfMediStockTheme
import com.app.lontara.adminofmedistock.ui.theme.WhiteColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navHostController = rememberNavController()
            val viewModel: ViewModel by viewModels()

            AdminOfMediStockTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                        .background(color = WhiteColor)
                ) { innerPadding ->

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(color = WhiteColor)
                    ) {
                        NavGraph(navHostController = navHostController, viewModel = viewModel)
                    }
                }
            }
        }
    }
}
