package com.example.jetpackcomposecatalogo.ui.radiobutton

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

/**
 * Created by Fernando Moreno on 23/3/2023.
 * E-Mail: morenofernando@gmail.com
 */
@Composable
fun MyRadioButton() {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = false,
            onClick = { },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Cyan,
                disabledColor = Color.LightGray
            )
        )
        Text(text = "Ejemplo")
    }
}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Fernando",
                onClick = { onItemSelected("Fernando") }
            )
            Text(text = "Fernando")
        }
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Daiana",
                onClick = { onItemSelected("Daiana") }
            )
            Text(text = "Daiana")
        }
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Elian",
                onClick = { onItemSelected("Elian") }
            )
            Text(text = "Elian")
        }
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Toby",
                onClick = { onItemSelected("Toby") }
            )
            Text(text = "Toby")
        }
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = name == "Ambar",
                onClick = { onItemSelected("Ambar") }
            )
            Text(text = "Ambar")
        }
    }
}

@Composable
fun PrincipalRadioButton() {
    var selected by remember {
        mutableStateOf("Fernando")
    }
    MyRadioButtonList(name = selected, onItemSelected = { selected = it })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogoTheme {
        PrincipalRadioButton()
    }
}