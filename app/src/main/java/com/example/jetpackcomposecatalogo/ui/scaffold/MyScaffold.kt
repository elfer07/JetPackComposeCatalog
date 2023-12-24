package com.example.jetpackcomposecatalogo.ui.scaffold

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalogo.ui.lists.MyList
import kotlinx.coroutines.launch

/**
 * Created by Fernando Moreno on 28/3/2023.
 * E-Mail: morenofernando@gmail.com
 */
@Composable
fun MyScaffold() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            MyTopAppBar(onClickIcon = {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("Has pulsado $it")
                }
            }, onClickDrawer = {
                coroutineScope.launch {
                    scaffoldState.drawerState.open()
                }
            })
        },
        floatingActionButton = { MyFloatingActionButton() },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = false,
        drawerContent = { MyDrawer {
            coroutineScope.launch {
                scaffoldState.drawerState.close()
            }
        } },
        drawerGesturesEnabled = true,
        bottomBar = {
            MyBottomNavigation()
        },
        scaffoldState = scaffoldState
    ) {
        MyList()
    }

}

@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit, onClickDrawer: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Toolbar") },
        backgroundColor = Color.Red,
        contentColor = Color.White,
        navigationIcon = {
            IconButton(onClick = { onClickDrawer() }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Buscar") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "")
            }
            IconButton(onClick = { onClickIcon("Peligro") }) {
                Icon(imageVector = Icons.Filled.Dangerous, contentDescription = "")
            }
        }
    )
}

@Composable
fun MyBottomNavigation() {
    var index by remember {
        mutableStateOf(0)
    }
    BottomNavigation(backgroundColor = Color.Red, contentColor = Color.White) {
        BottomNavigationItem(selected = index == 0, onClick = { index = 0 }, icon = {
            Icon(imageVector = Icons.Filled.Home, contentDescription = "")
        }, label = { Text(text = "Home") })
        BottomNavigationItem(selected = index == 1, onClick = { index = 1 }, icon = {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = "")
        }, label = { Text(text = "Favorite") })
        BottomNavigationItem(selected = index == 2, onClick = { index = 2 }, icon = {
            Icon(imageVector = Icons.Filled.Person, contentDescription = "")
        }, label = { Text(text = "Person") })
    }
}

@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        backgroundColor = Color.Green,
        contentColor = Color.Black
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "add")

    }
}

@Composable
fun MyDrawer(onCloseDrawer: () -> Unit) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "Option 1", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onCloseDrawer() }
        )

        Text(text = "Option 2", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onCloseDrawer() }
        )
        Text(text = "Option 3", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onCloseDrawer() }
        )
        Text(text = "Option 4", modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onCloseDrawer() }
        )
    }
}

@Preview
@Composable
fun MyScaffoldPreview() {
    MyScaffold()
}