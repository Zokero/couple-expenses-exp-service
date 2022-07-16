package com.kukit.platform.expenses.domain.ports;


import com.kukit.platform.expenses.domain.Expense;

import java.util.Collection;
import java.util.Optional;

public interface Repository {

    void add(Expense expense);

    void remove(Long expenseId);

    void editExpense(Expense expense);

    Optional<Expense> get(Long expenseId);

    Collection<Expense> getAll();

    Collection<Expense> getExpensesBy(Long userId);
}
