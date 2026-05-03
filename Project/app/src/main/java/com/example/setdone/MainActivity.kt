package com.example.setdone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.setdone.data.local.WorkoutDatabase
import com.example.setdone.data.repository.WorkoutRepository
import com.example.setdone.navigation.NavGraph
import com.example.setdone.ui.theme.SetDoneTheme
import com.example.setdone.ui.viewmodel.WorkoutViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Manual DI for simplicity in this example
        val database = WorkoutDatabase.getDatabase(this)
        val repository = WorkoutRepository(database.workoutDao())
        val viewModelFactory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return WorkoutViewModel(repository) as T
            }
        }
        val viewModel = ViewModelProvider(this, viewModelFactory)[WorkoutViewModel::class.java]

        setContent {
            SetDoneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavGraph(navController = navController, viewModel = viewModel)
                }
            }
        }
    }
}
