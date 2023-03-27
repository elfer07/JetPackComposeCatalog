package com.example.jetpackcomposecatalogo.ui.badgebox

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BadgedBox
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

/**
 * Created by Fernando Moreno on 23/3/2023.
 * E-Mail: morenofernando@gmail.com
 */
@Composable
fun MyBadgeBox() {
    BadgedBox(
        modifier = Modifier.padding(20.dp),
        badge = {
            Text(
                modifier = Modifier
                    .padding(10.dp)
                    .clip(CircleShape)
                    .background(Color.Red),
                text = "1"
            )
        }
    ) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "Star")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogoTheme {
        MyBadgeBox()
    }
}