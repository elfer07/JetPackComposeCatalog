package com.example.jetpackcomposecatalogo.ui.lists

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecatalogo.R
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme
import kotlinx.coroutines.launch

/**
 * Created by Fernando Moreno on 28/3/2023.
 * E-Mail: morenofernando@gmail.com
 */
@Composable
fun MyList() {
    val myList = listOf(
        Person("Fernando", "Moreno", 39),
        Person("Daiana", "Soto", 35),
        Person("Elian", "Moreno", 3),
        Person("Federico", "Moreno", 37),
        Person("Nicolas", "Moreno", 38)
    )
    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
        item { Text(text = "Header", fontSize = 25.sp, fontWeight = FontWeight.Bold) }
        items(myList) {
            Text(text = "Hola ${it.name} ${it.surname}, tienes ${it.age} años de edad.")
        }
        item { Text(text = "Footer", fontSize = 25.sp, fontWeight = FontWeight.Bold) }
    }
}

@Composable
fun MyListRow() {
    val context = LocalContext.current
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHero()) {
            ItemHero(superHero = it) { it1 ->
                Toast.makeText(context, it1.realName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun MyListGrid() {
    val context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        items(getSuperHero()) {
            ItemHero(superHero = it) { it1 ->
                Toast.makeText(context, it1.realName, Toast.LENGTH_SHORT).show()
            }
        }
    })
}

@Composable
fun MyListCustom() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            state = rvState, verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally)
        ) {
            items(getSuperHero()) {
                ItemHero(superHero = it) { it1 ->
                    Toast.makeText(context, it1.realName, Toast.LENGTH_SHORT).show()
                }
            }
        }

        val showButton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }

        if (showButton) {
            Button(modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(8.dp), onClick = {
                coroutineScope.launch {
                    rvState.animateScrollToItem(0)
                }
            }) {
                Text(text = "Action")
            }
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyListSticky() {
    val context = LocalContext.current
    val supers: Map<String, List<SuperHero>> = getSuperHero().groupBy { it.publisher }
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp))
    {
        supers.forEach {
            stickyHeader {
                Text(
                    text = it.key,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            items(it.value) { superHero ->
                ItemHero(superHero = superHero) { it1 ->
                    Toast.makeText(context, it1.realName, Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}

@Composable
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red), modifier = Modifier
            .width(200.dp)
            .padding(all = 8.dp)
    ) {
        Column() {
            Image(
                painter = painterResource(id = superHero.image),
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemSelected(superHero)
                    },
                contentScale = ContentScale.Crop
            )
            Text(text = superHero.name, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(
                text = superHero.realName,
                fontSize = 12.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.publisher,
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 5.dp)
            )
        }
    }
}

private fun getSuperHero(): List<SuperHero> {
    return listOf(
        SuperHero("Spiderman", "Peter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Wolverine", "Logan", "Marvel", R.drawable.logan),
        SuperHero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        SuperHero("Thor", "Thor Odison", "Marvel", R.drawable.thor),
        SuperHero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        SuperHero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern),
        SuperHero("Spiderman", "Princess Diana", "DC", R.drawable.wonder_woman)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogoTheme {
        MyList()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    JetpackComposeCatalogoTheme {
        MyListRow()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    JetpackComposeCatalogoTheme {
        MyListGrid()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    JetpackComposeCatalogoTheme {
        MyListCustom()
    }
}