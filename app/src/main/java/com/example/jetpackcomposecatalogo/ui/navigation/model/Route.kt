package com.example.jetpackcomposecatalogo.ui.navigation.model

/**
 * Created by Fernando Moreno on 28/3/2023.
 * E-Mail: morenofernando@gmail.com
 */
sealed class Route(
    val route: String
) {
    object Screen1: Route("screen1")
    object Screen2: Route("screen2")
    object Screen3: Route("screen3")
    object Screen4: Route("screen4/{name}") {
        fun createRoute(name: String) = "screen4/$name"
    }
    object Screen5: Route("screen5?age={age}") {
        fun createRoute(age: Int) = "screen5?age=$age"
    }
}
