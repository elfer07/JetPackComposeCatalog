package com.example.jetpackcomposecatalogo.ui.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalogo.R
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

/**
 * Created by Fernando Moreno on 23/3/2023.
 * E-Mail: morenofernando@gmail.com
 */
@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.dbo),
        contentDescription = "example",
        alpha = 0.5f
    )
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.dbo),
        contentDescription = "example",
        modifier = Modifier
            .clip(
                RoundedCornerShape(25f)
            )
            .border(width = 5.dp, Color.Red, shape = RoundedCornerShape(25f))
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogoTheme {
        MyImage()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewAdvance() {
    JetpackComposeCatalogoTheme {
        MyImageAdvance()
    }
}