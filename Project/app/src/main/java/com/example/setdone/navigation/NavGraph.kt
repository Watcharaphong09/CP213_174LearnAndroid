package com.example.setdone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.setdone.ui.screens.AddExerciseScreen
import com.example.setdone.ui.screens.DashboardScreen
import com.example.setdone.ui.screens.SummaryScreen
import com.example.setdone.ui.screens.WorkoutScreen
import com.example.setdone.ui.viewmodel.WorkoutViewModel

sealed class Screen(val route: String) {
    object Dashboard : Screen("dashboard")
    object AddExercise : Screen("add_exercise")
    object Workout : Screen("workout")
    object Summary : Screen("summary")
}

@Composable
fun NavGraph(
    navController: NavHostController,
    viewModel: WorkoutViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Dashboard.route
    ) {
        composable(Screen.Dashboard.route) {
            DashboardScreen(
                viewModel = viewModel,
                onAddExercise = { 
                    viewModel.setEditingExercise(null)
                    navController.navigate(Screen.AddExercise.route) 
                },
                onEditExercise = { exercise ->
                    viewModel.setEditingExercise(exercise)
                    navController.navigate(Screen.AddExercise.route)
                },
                onStartWorkout = { exercise ->
                    viewModel.startWorkout(exercise)
                    navController.navigate(Screen.Workout.route)
                }
            )
        }
        
        composable(Screen.AddExercise.route) {
            AddExerciseScreen(
                viewModel = viewModel,
                onBack = { 
                    viewModel.setEditingExercise(null)
                    navController.popBackStack() 
                }
            )
        }
        
        composable(Screen.Workout.route) {
            WorkoutScreen(
                viewModel = viewModel,
                onFinish = { navController.navigate(Screen.Summary.route) }
            )
        }
        
        composable(Screen.Summary.route) {
            SummaryScreen(
                onHome = { 
                    navController.navigate(Screen.Dashboard.route) {
                        popUpTo(Screen.Dashboard.route) { inclusive = true }
                    }
                }
            )
        }
    }
}
