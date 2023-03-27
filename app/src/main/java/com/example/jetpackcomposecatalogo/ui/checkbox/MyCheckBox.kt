package com.example.jetpackcomposecatalogo.ui.checkbox

import androidx.compose.foundation.layout.*
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.material.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme
import java.security.Principal

/**
 * Created by Fernando Moreno on 23/3/2023.
 * E-Mail: morenofernando@gmail.com
 */
@Composable
fun MyCheckBox() {
    var status by rememberSaveable { mutableStateOf(false) }
    Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = status,
            onCheckedChange = {
                status = !status
            },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Green,
                checkmarkColor = Color.Blue
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text( text = "Check Box")
    }
}

@Composable
fun MyCheckBoxAdvanced(checkInfo: CheckInfo) {
    Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = {
                checkInfo.onCheckedChange(!checkInfo.selected)
            },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Green,
                checkmarkColor = Color.Blue
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text( text = checkInfo.title)
    }
}

@Composable
fun MyTriStateCheckbox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(
        state = status,
        onClick = {
            status = when (status) {
                ToggleableState.On -> {
                    ToggleableState.Off
                }
                ToggleableState.Off -> {
                    ToggleableState.Indeterminate
                }
                ToggleableState.Indeterminate -> {
                    ToggleableState.On
                }
            }
        }
    )
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable {
            mutableStateOf(false)
        }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { newStatus ->
                status = newStatus
            }
        )
    }
}

@Composable
fun Principal() {
    val myOptions = getOptions(titles = listOf("Fernando", "Daiana", "Elian"))
    Column {
        MyTriStateCheckbox()
        myOptions.forEach {
            MyCheckBoxAdvanced(it)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogoTheme {
        MyCheckBox()
    }
}