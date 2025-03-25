package com.estrhup.expenseskmp.data

import com.estrhup.expenseskmp.model.Expense
import com.estrhup.expenseskmp.model.ExpenseCategory
import kotlin.math.exp

object ExpenseManager {

    private var currentId = 1L

    val mockExpenseList = mutableListOf(
        Expense(
            id = currentId++,
            amount = 70.0,
            category = ExpenseCategory.GROCERIES,
            description = "Weekly buy"
        ),
        Expense(
            id = currentId++,
            amount = 30.0,
            category = ExpenseCategory.SNACKS,
            description = "Hommies"
        ),
        Expense(
            id = currentId++,
            amount = 120.0,
            category = ExpenseCategory.PARTY,
            description = "Weekend party"
        ),
        Expense(
            id = currentId++,
            amount = 7220.0,
            category = ExpenseCategory.CAR,
            description = "Audi A2"
        ),
        Expense(
            id = currentId++,
            amount = 870.0,
            category = ExpenseCategory.HOUSE,
            description = "Services"
        ),
    )

    fun addNewExpense(expense: Expense) {
        mockExpenseList.add(expense.copy(id = currentId++)) //Add new element with new id
    }

    fun editExpense(expense: Expense) {
        val index = mockExpenseList.indexOfFirst {
            it.id == expense.id //Edit expense created
        }
        if (index != -1) {
            mockExpenseList[index] = mockExpenseList[index].copy(
                amount = expense.amount,
                category = expense.category,
                description = expense.description
            ) //replace element of list
        }
    }

    fun getCategories(): List<ExpenseCategory> {
        return listOf(
            ExpenseCategory.CAR,
            ExpenseCategory.COFFEE,
            ExpenseCategory.HOUSE,
            ExpenseCategory.PARTY,
            ExpenseCategory.SNACKS,
            ExpenseCategory.OTHER
        )
    }
}