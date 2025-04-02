package com.estrhup.expenseskmp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.estrhup.expenseskmp.data.TitleTopBarTypes
import com.estrhup.expenseskmp.navigation.Navigation
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator

@Composable
fun App() {
    PreComposeApp {

        val colors = getColorsTheme()

        AppTheme {

            val navigator = rememberNavigator()
            val titleTopBar = getTitleTopAppBar(navigator)
            val isEditOrAddExpense = titleTopBar != TitleTopBarTypes.DASHBOARD.value

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    TopAppBar(elevation = 0.dp,
                        title = {
                            Text(text= titleTopBar,
                                fontSize = 25.sp,
                                color = colors.textColor)
                        },
                        navigationIcon = {
                            if(isEditOrAddExpense) {
                                IconButton(
                                    onClick = {
                                        navigator.popBackStack()
                                    }
                                ) {
                                    Icon(
                                        modifier = Modifier.padding(start = 16.dp),
                                        imageVector = Icons.Default.ArrowBack,
                                        tint = colors.textColor,
                                        contentDescription = "Back arrow"
                                    )
                                }
                            } else {
                                Icon(
                                    modifier = Modifier.padding(start = 16.dp),
                                    imageVector = Icons.Default.Apps,
                                    tint = colors.textColor,
                                    contentDescription = "Back arrow"
                                )
                            }
                        },
                        backgroundColor = colors.backgroundColor
                    )
                },
                floatingActionButton = {
                    if(!isEditOrAddExpense) {
                        FloatingActionButton(
                            modifier = Modifier.padding(8.dp),
                            onClick = {
                                navigator.navigate("/addExpense")
                            },
                            shape = RoundedCornerShape(50),
                            contentColor = Color.White,
                            backgroundColor = colors.addIconColor
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                tint = Color.White,
                                contentDescription = "Floating button"
                            )
                        }
                    }
                }
            ) {
                Navigation(navigator)
            }
        }
    }
}

@Composable
fun getTitleTopAppBar(navigator: Navigator): String {
    var titleTopBar = TitleTopBarTypes.DASHBOARD.value

    val isAddExpense = navigator.currentEntry.collectAsState(null).value?.route?.route.equals("/addExpense/{id}?")
    if(isAddExpense) {
        titleTopBar = TitleTopBarTypes.ADD.value
    }

    val isEditExpense = navigator.currentEntry.collectAsState(null).value?.path<Long>("id")
    if(isEditExpense != null) {
        titleTopBar = TitleTopBarTypes.EDIT.value
    }

    return titleTopBar
}
