package com.example.jetpackcomposecatalogo.ui.progress

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

/**
 * Created by Fernando Moreno on 23/3/2023.
 * E-Mail: morenofernando@gmail.com
 */
@Composable
fun MyProgress() {
    var showLoading by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(
                color = Color.Red,
                strokeWidth = 6.dp
            )

            LinearProgressIndicator(
                modifier = Modifier.padding(top = 16.dp),
                backgroundColor = Color.Cyan
            )
        }

        Button(
            onClick = { showLoading = !showLoading },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            if (showLoading) {
                Text(text = "Ocultar" )
            } else {
                Text(text = "Mostrar" )
            }
        }
    }
}

@Composable
fun MyProgressAdvance() {
    var status by rememberSaveable {
        mutableStateOf(0.0f)
    }
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        CircularProgressIndicator(
            progress = status
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Increment",
                modifier = Modifier
                    .padding(end = 10.dp)
                    .clickable {
                        if (status in 0f..1f) {
                            status += 0.1f
                        }
                    },
            )
            Icon(
                imageVector = Icons.Default.Minimize,
                contentDescription = "Decrement",
                modifier = Modifier
                    .clickable {
                        if (status >= 0.1f) {
                            status -= 0.1f
                        }
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogoTheme {
        MyProgressAdvance()
    }
}