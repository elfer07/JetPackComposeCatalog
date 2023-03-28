package com.example.jetpackcomposecatalogo.ui.lists

import androidx.annotation.DrawableRes

/**
 * Created by Fernando Moreno on 28/3/2023.
 * E-Mail: morenofernando@gmail.com
 */
data class SuperHero(
    val name: String,
    val realName: String,
    val publisher: String,
    @DrawableRes val image: Int
)
