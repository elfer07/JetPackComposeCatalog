package com.example.jetpackcomposecatalogo.ui.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

/**
 * Created by Fernando Moreno on 22/3/2023.
 * E-Mail: morenofernando@gmail.com
 */
@Composable
fun MyTextField() {
    var myText by remember { mutableStateOf("Escribi aqui") }

    TextField(value = myText, onValueChange = {
        myText = it
    }
    )
}

@Composable
fun MyTextFieldAdvance() {
    var myText by remember { mutableStateOf("") }
    Column() {
        TextField(
            value = myText,
            onValueChange = {
                myText = if (it.contains("a")) {
                    it.replace("a", "b")
                } else {
                    it
                }
            },
            label = {
                Text(text = "Introduce tu nombre")
            }
        )
    }
}

@Composable
fun MyTextFieldOutlined() {
    var myText by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier= Modifier.fillMaxWidth().padding(24.dp),
        value = myText,
        label = { Text(text = "Ingrese su nombre") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Green,
            unfocusedBorderColor = Color.Red
        ),
        onValueChange = {
            myText = it
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogoTheme {
        MyTextFieldOutlined()
    }
}