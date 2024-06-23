package com.app.lontara.medicalstoreapp.screens

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.app.lontara.medicalstoreapp.navigation.NavGraph
import com.app.lontara.medicalstoreapp.repo.Repo
import com.app.lontara.medicalstoreapp.ui.theme.MedicalStoreAppTheme
import com.app.lontara.medicalstoreapp.screens.viewModel.ViewModel


// MainActivity is the entry point of the app
class MainActivity : ComponentActivity() {

    // Extension function to get DataStore instance from Context
   private val Context.dataStore : DataStore<Preferences> by preferencesDataStore("User_Data")

    // Extension function to get Repo from Context
    private val Context.repo: Repo
        get() = Repo()

    private val viewModel by viewModels<ViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
                return ViewModel(context = this@MainActivity, repo = repo) as T
            }
        }
    }
//    // Get an instance of PreferencesViewModel
//    private val viewModel: ViewModel by viewModels {
//        ViewModelFactory(repo = repo)
//    }

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MedicalStoreAppTheme {

                val navHostController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerpadding ->

                    Column(
                        modifier = Modifier
                            .background(color = Color.White)
                            .fillMaxSize()
                            .padding(innerpadding)
                    ) {

                        NavGraph(viewModel = viewModel, navHostController = navHostController)
                    }
                }


            }
        }
    }
}
