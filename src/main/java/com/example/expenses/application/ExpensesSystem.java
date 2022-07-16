package com.example.expenses.application;


import com.example.expenses.domain.Expense;

import java.util.Collection;
import java.util.Optional;

public interface ExpensesSystem {

    void addExpense(Expense expense);

    void editExpense(Expense expense);

    Collection<Expense> getExpenses();

    Collection<Expense> getExpensesBy(Long userId);

    Optional<Expense> getExpense(long l);
}
