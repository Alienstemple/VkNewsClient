package com.sumin.vknewsclient

import android.util.Log
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import com.sumin.vknewsclient.ui.theme.NavigationItem
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val snackbarHostState = SnackbarHostState()
    val isFabVisible = remember {
        mutableStateOf(true)
    }
    val scope = rememberCoroutineScope()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                Log.d("TAG", "Redraw")
                val selectedItemPosition = remember {
                    mutableStateOf(0)
                }
                val items =
                    listOf(NavigationItem.Home, NavigationItem.Favourite, NavigationItem.Profile)
                items.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        selected = selectedItemPosition.value == index,
                        onClick = {
                            selectedItemPosition.value = index
                        },
                        icon = {
                            Icon(item.icon, contentDescription = null)
                        },
                        label = {
                            Text(stringResource(id = item.titleResId))
                        },
                        selectedContentColor = MaterialTheme.colors.onPrimary,
                        unselectedContentColor = MaterialTheme.colors.onSecondary
                    )
                }
            }
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            if (isFabVisible.value) {
                FloatingActionButton(onClick = {
                    scope.launch {
                        val action = snackbarHostState.showSnackbar(
                            message = "this is snack!",
                            actionLabel = "hide fabe",
                            duration = SnackbarDuration.Long
                        )
                        if (action == SnackbarResult.ActionPerformed) {
                            isFabVisible.value = false
                        }
                    }
                }) {
                    Icon(Icons.Filled.Favorite, contentDescription = null)
                }
            }
        }
    ) {

    }
}