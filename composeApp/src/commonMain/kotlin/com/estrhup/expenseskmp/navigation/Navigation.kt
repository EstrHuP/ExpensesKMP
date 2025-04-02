package com.estrhup.expenseskmp.navigation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.estrhup.expenseskmp.data.ExpenseManager
import com.estrhup.expenseskmp.data.ExpenseRepoImpl
import com.estrhup.expenseskmp.getColorsTheme
import com.estrhup.expenseskmp.presentation.ExpensesViewModel
import com.estrhup.expenseskmp.ui.ExpensesScreen
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path

@Composable
fun Navigation(navigator: Navigator) {

    val colors = getColorsTheme()
    val viewModel = remember {
        ExpensesViewModel(ExpenseRepoImpl(ExpenseManager))
    }

    //Destinations to navigate
    NavHost(
        modifier = Modifier.background(colors.backgroundColor),
        navigator = navigator,
        initialRoute = "/home"
    ) {
        scene(route = "/home") {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            ExpensesScreen(uiState) { expense ->
                //Navigate to next screen
                navigator.navigate("/addExpense/${expense.id}")
            }
        }

        scene(route = "/addExpense/{id}") {
            val idFromPath = it.path<Long>("id") //Get last id (expense.id)
            val isAddExpense = idFromPath?.let { id -> viewModel.getExpenseId(id) } //(.let) == (if != nil)

            //TODO: ExpenseDetailScreen
            }
        }
    }