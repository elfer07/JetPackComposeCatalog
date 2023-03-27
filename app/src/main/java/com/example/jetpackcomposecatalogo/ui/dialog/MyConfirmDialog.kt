package com.example.jetpackcomposecatalogo.ui.dialog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.jetpackcomposecatalogo.ui.radiobutton.MyRadioButtonList
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme
import com.example.jetpackcomposecatalogo.ui.theme.Shapes

/**
 * Created by Fernando Moreno on 23/3/2023.
 * E-Mail: morenofernando@gmail.com
 */
@Composable
fun MyConfirmDialog(
    show: Boolean,
    onDismiss: () -> Unit
) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .border(border = BorderStroke(1.dp, Color.Gray), RoundedCornerShape(8.dp))
                .background(Color.White)) {
                MyTitleDialog(text = "Phone ringtone", modifier = Modifier.padding(24.dp))
                Divider(Modifier.fillMaxWidth(), Color.LightGray)
                var status by remember {
                    mutableStateOf("")
                }
                MyRadioButtonList(name = status, onItemSelected = { status = it })
                Divider(Modifier.fillMaxWidth(), Color.LightGray)
                Row(modifier = Modifier.align(Alignment.End).padding(8.dp)) {
                    TextButton(onClick = {  }) {
                        Text(text = "CANCEL")
                    }
                    TextButton(onClick = {  }) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}

@Composable
fun MyCustomConfirmDialogExamplePrincipal() {
    val context = LocalContext.current
    var show by remember {
        mutableStateOf(false)
    }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { show = !show }) {
            Text(text = "Mostrar Dialogo")
        }
        MyConfirmDialog(show = show, onDismiss = { show = !show })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview1() {
    JetpackComposeCatalogoTheme() {
        MyConfirmDialog(true, {})
    }
}