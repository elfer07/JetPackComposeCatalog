package com.example.jetpackcomposecatalogo.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.jetpackcomposecatalogo.ui.navigation.model.Route
import com.example.jetpackcomposecatalogo.ui.navigation.model.Route.Screen4.createRoute

/**
 * Created by Fernando Moreno on 28/3/2023.
 * E-Mail: morenofernando@gmail.com
 */
@Composable
fun Screen1(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Pantalla 1", modifier = Modifier.align(Alignment.Center).clickable {
            navController.navigate(Route.Screen2.route)
        })
    }
    
}

@Composable
fun Screen2(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Green)) {
        Text(text = "Pantalla 2", modifier = Modifier.align(Alignment.Center).clickable {
            navController.navigate(Route.Screen3.route)
        })
    }

}

@Composable
fun Screen3(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Red)) {
        Text(text = "Pantalla 3", modifier = Modifier.align(Alignment.Center).clickable {
            navController.navigate(createRoute("Fernando Moreno"))
        })
    }

}

@Composable
fun Screen4(navController: NavHostController, name: String) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Blue)) {
        Text(text = "Hola me llamo $name", modifier = Modifier.align(Alignment.Center).clickable {
            navController.navigate(Route.Screen5.createRoute(39))
        })
    }

}

@Composable
fun Screen5(navController: NavHostController, age: Int?) {
    Box(modifier = Modifier.fillMaxSize().background(Color.Blue)) {
        Text(text = "tengo $age años de edad", modifier = Modifier.align(Alignment.Center).clickable {

        })
    }

}