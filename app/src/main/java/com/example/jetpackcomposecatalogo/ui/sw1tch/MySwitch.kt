package com.example.jetpackcomposecatalogo.ui.sw1tch

import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

/**
 * Created by Fernando Moreno on 23/3/2023.
 * E-Mail: morenofernando@gmail.com
 */
@Composable
fun MySwitch() {
    var status by rememberSaveable { mutableStateOf(false) }
    Switch(
        checked = status,
        onCheckedChange = {
            status = !status
        },
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            uncheckedTrackColor = Color.Black,
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Red
        )
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogoTheme {
        MySwitch()
    }
}