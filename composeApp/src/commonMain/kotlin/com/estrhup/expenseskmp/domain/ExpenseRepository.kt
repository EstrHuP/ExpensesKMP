package com.estrhup.expenseskmp.domain

import com.estrhup.expenseskmp.model.Expense
import com.estrhup.expenseskmp.model.ExpenseCategory

interface ExpenseRepository {
    fun getAllExpenses(): List<Expense>
    fun addExpense(expense: Expense)
    fun editExpense(expense: Expense)
    fun getCategories(): List<ExpenseCategory>
}