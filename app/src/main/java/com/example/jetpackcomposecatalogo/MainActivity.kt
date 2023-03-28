package com.example.jetpackcomposecatalogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposecatalogo.ui.navigation.*
import com.example.jetpackcomposecatalogo.ui.navigation.model.Route
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(
                        navController = navigationController,
                        startDestination = Route.Screen1.route
                    ) {
                        composable(Route.Screen1.route) { Screen1(navigationController) }
                        composable(Route.Screen2.route) { Screen2(navigationController) }
                        composable(Route.Screen3.route) { Screen3(navigationController) }
                        composable(
                            route = Route.Screen4.route,
                            arguments = listOf(navArgument("name") { type = NavType.StringType })
                        ) {
                            Screen4(
                                navigationController,
                                it.arguments?.getString("name") ?: "NO NAME"
                            )
                        }
                        composable(Route.Screen5.route, arguments = listOf(navArgument("age") {
                            defaultValue = 0
                        })) {
                            Screen5(
                                navController = navigationController,
                                age = it.arguments?.getInt("age")
                            )
                        }
                    }

                }
            }
        }
    }
}