package com.example.expenses.infrastructure;



import com.example.expenses.domain.Expense;
import com.example.expenses.domain.ports.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryRepository implements Repository {

    private final Map<Long, Expense> expenses = new HashMap<>();


    @Override
    public void add(Expense expense) {
        expenses.put(expense.getId(), expense);
    }

    @Override
    public Optional<Expense> get(Long expenseId) {
        return Optional.ofNullable(expenses.get(expenseId));
    }

    @Override
    public void remove(Long expenseId) {
        expenses.remove(expenseId);
    }

    @Override
    public void editExpense(Expense expense) {
        expenses.put(expense.getId(), expense);
    }

    @Override
    public Collection<Expense> getAll() {
        return expenses.values();
    }

    @Override
    public Collection<Expense> getExpensesBy(Long userId) {
        return expenses.values().stream().filter(k -> k.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
