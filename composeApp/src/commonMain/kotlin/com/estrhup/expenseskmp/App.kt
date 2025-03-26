package com.estrhup.expenseskmp

import androidx.compose.runtime.*
import com.estrhup.expenseskmp.data.ExpenseManager
import com.estrhup.expenseskmp.data.ExpenseRepoImpl
import com.estrhup.expenseskmp.presentation.ExpensesViewModel
import com.estrhup.expenseskmp.ui.ExpensesScreen
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.viewmodel.viewModel

@Composable
fun App() {
    PreComposeApp {

        val colors = getColorsTheme()
        val viewModel = remember {
            ExpensesViewModel(ExpenseRepoImpl(ExpenseManager))
        }
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        AppTheme {
            ExpensesScreen(
                uiState = uiState,
                onExpenseClick = { }
            )
        }
    }
}
