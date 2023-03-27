package com.example.jetpackcomposecatalogo.ui.dialog

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.jetpackcomposecatalogo.R
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

/**
 * Created by Fernando Moreno on 23/3/2023.
 * E-Mail: morenofernando@gmail.com
 */
@Composable
fun MyDialog(onDismiss: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(onDismissRequest = { },
        title = { Text(text = "Titulo de Dialogo") },
        text = { Text(text = "Descripción del dialogo") },
        confirmButton = {
            TextButton(onClick = { onConfirm() }) {
                Text(text = "Confirmar")
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text(text = "Salir")
            }
        }
    )
}

@Composable
fun ShowDialog(show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {
    if (show) {
        MyDialog(
            onConfirm = {
                onConfirm()
            },
            onDismiss = {
                onDismiss()
            }
        )
    }
}

@Composable
fun DialogPrincipal() {
    val context = LocalContext.current
    var show by remember {
        mutableStateOf(false)
    }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = !show }) {
            Text(text = "Mostrar Dialogo")
        }
        ShowDialog(show = show, onDismiss = { show = !show }, onConfirm = {
            Toast.makeText(context, "Confiramado!", Toast.LENGTH_SHORT).show()
        })
    }
}

@Composable
fun MyCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Column(
            modifier = Modifier
                .background(Color.Gray)
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Ejemplo de dialogo")
            Text(text = "Ejemplo de dialogo")
            Text(text = "Ejemplo de dialogo")
        }
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {

        }
    }
}

@Composable
fun MyCustomDialogExamplePrincipal() {
    val context = LocalContext.current
    var show by remember {
        mutableStateOf(false)
    }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = !show }) {
            Text(text = "Mostrar Dialogo")
        }
        MyCustomDialogExample(show = show, onDismiss = { show = !show })
    }
}

@Composable
fun MyCustomDialogExample(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitleDialog(text = "Set Backup account")
                AccountItem(email = "user01@gmail.com", drawable = R.drawable.goku)
                AccountItem(email = "user02@gmail.com", drawable = R.drawable.ironman)
                AccountItem(email = "Añadir nueva cuenta", drawable = R.drawable.add)
            }
        }
    }
}

@Composable
fun MyTitleDialog(text: String, modifier: Modifier = Modifier.padding(bottom = 12.dp)) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogoTheme {
        MyDialog({}, {})
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    JetpackComposeCatalogoTheme {
        MyCustomDialog(true, {})
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    JetpackComposeCatalogoTheme {
        MyCustomDialogExample(true, {})
    }
}