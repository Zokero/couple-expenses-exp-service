package com.example.expenses;

import com.example.expenses.application.ExpensesSystem;
import com.example.expenses.domain.Expense;
import com.example.expenses.domain.exceptions.ExpenseAlreadyExists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.example.expenses.application.ExpensesSystemConfiguration.expensesSystem;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.BDDAssertions.then;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ExpensesSystemAddScenarios {

    private ExpensesSystem expensesSystem;

    @BeforeEach
    void beforeEach() {
        expensesSystem = expensesSystem();
    }

    @Test
    void Add_new_expense() {
        //Given
        Expense expense = new Expense(1L,1L, LocalDateTime.now(), "storeName", "productName");

        //When
        expensesSystem.addExpense(expense);

        //Then
        then(expensesSystem.getExpense(1L).get()).isEqualTo(expense);
    }

    @Test
    void Add_multiple_new_expenses() {
        //Given
        Expense expense1 = new Expense(1L, 1L, LocalDateTime.now(), "storeName", "productName");
        Expense expense2 = new Expense(2L, 1L, LocalDateTime.now(), "storeName", "productName");

        //When
        expensesSystem.addExpense(expense1);
        expensesSystem.addExpense(expense2);

        //Then
        then(expensesSystem.getExpense(1L).get()).isEqualTo(expense1);
    }

    @Test
    void Report_error_on_adding_existing_expense() {
        //Given
        Expense expense1 = new Expense(1L, 1L, LocalDateTime.now(), "storeName", "productName");
        Expense expense2 = new Expense(1L, 1L, LocalDateTime.now(), "storeName", "productName");

        expensesSystem.addExpense(expense1);

        //When
        var throwable = catchThrowable(() -> expensesSystem.addExpense(expense2));

        //Then
        then(throwable).isInstanceOf(ExpenseAlreadyExists.class).hasMessage("Expense with id: 1 already exists!");
    }
}
