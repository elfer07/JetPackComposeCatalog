package com.example.jetpackcomposecatalogo.ui.animation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalogo.R
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme
import kotlin.random.Random.Default.nextInt

/**
 * Created by Fernando Moreno on 31/3/2023.
 * E-Mail: morenofernando@gmail.com
 */
@Composable
fun MyAnimation() {
    Column() {
        var firstColor by rememberSaveable {
            mutableStateOf(false)
        }
        val realColor = if (firstColor) Color.Red else Color.Green
        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor)
            .clickable {
                firstColor = !firstColor
            }
        ) {

        }

        Spacer(modifier = Modifier.size(200.dp))

        var secondColor by rememberSaveable {
            mutableStateOf(false)
        }
        val realColor2 by animateColorAsState(targetValue = if (secondColor) Color.Red else Color.Green)
        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor2)
            .clickable {
                secondColor = !secondColor
            }
        ) {

        }
    }
}

@Composable
fun MyOtherAnimation() {
    var firstColor by rememberSaveable {
        mutableStateOf(false)
    }
    var showBox by rememberSaveable {
        mutableStateOf(true)
    }
    val realColor by animateColorAsState(
        targetValue = if (firstColor) Color.Red else Color.Green,
        animationSpec = tween(durationMillis = 2000),
        finishedListener = { showBox = false }
    )
    if (showBox) {
        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor)
            .clickable {
                firstColor = !firstColor
            }
        ) {

        }
    }
}

@Composable
fun MySizeAnimation() {
    var smallSize by rememberSaveable {
        mutableStateOf(true)
    }
    val size by animateDpAsState(
        targetValue = if (smallSize) 50.dp else 100.dp,
        animationSpec = tween(durationMillis = 700),
        finishedListener = {
            if (!smallSize) {
                smallSize = !smallSize
            }
        }
    )
    Box(
        modifier = Modifier
            .size(size)
            .background(Color.Cyan)
            .clickable { smallSize = !smallSize }) {

    }
}

@Composable
fun MyVisibilityAnimation() {
    var isVisibly by remember {
        mutableStateOf(true)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {
            isVisibly = !isVisibly
        }) {
            Text(text = "Mostrar/Ocultar")
        }
        Spacer(modifier = Modifier.size(50.dp))
        AnimatedVisibility(visible = isVisibly) {
            Box(modifier = Modifier
                .size(150.dp)
                .background(Color.Red))

        }
    }
}

@Composable
fun MyCrossFadeAnimation() {
    var myComponentType: ComponentType by remember {
        mutableStateOf(ComponentType.TEXT)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {myComponentType = getComonent()}) {
            Text(text = "Cambiar componente")
        }
        Crossfade(targetState = myComponentType) {
            when (it) {
                ComponentType.TEXT -> Text(text = "Componente de Texto", fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold)
                ComponentType.BOX -> Box(modifier = Modifier
                    .size(50.dp)
                    .background(Color.Red))
                ComponentType.IMAGE -> Image(painter = painterResource(id = R.drawable.wonder_woman), contentDescription = "")
                ComponentType.ERROR -> Text(text = "ERROR")
            }
        }
    }
}
private fun getComonent(): ComponentType {
    return when (nextInt(from = 0, until = 4)) {
        0 -> ComponentType.TEXT
        1 -> ComponentType.BOX
        2 -> ComponentType.IMAGE
        else -> ComponentType.ERROR
    }
}

enum class ComponentType {
    TEXT, BOX, IMAGE, ERROR
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogoTheme {
        MyAnimation()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    JetpackComposeCatalogoTheme {
        MyOtherAnimation()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    JetpackComposeCatalogoTheme {
        MySizeAnimation()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    JetpackComposeCatalogoTheme {
        MyVisibilityAnimation()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    JetpackComposeCatalogoTheme {
        MyCrossFadeAnimation()
    }
}