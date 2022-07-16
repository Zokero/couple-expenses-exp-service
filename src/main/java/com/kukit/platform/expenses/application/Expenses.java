package com.kukit.platform.expenses.application;

import com.kukit.platform.expenses.domain.Expense;
import com.kukit.platform.expenses.domain.exceptions.ExpenseAlreadyExists;
import com.kukit.platform.expenses.domain.ports.Repository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.Optional;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Expenses implements ExpensesSystem {

    private final Repository repository;

    public static ExpensesSystem newInstance(Repository repository) {
        return new Expenses(repository);
    }

    @Override
    public void addExpense(Expense expense) {
        Optional<Expense> expense1 = repository.get(expense.getId());
        if(expense1.isEmpty()){
            repository.add(expense);
        }else{
            throw new ExpenseAlreadyExists("Expense with id: 1 already exists!");
        }
    }

    @Override
    public void editExpense(Expense expense) {
        repository.editExpense(expense);
    }

    @Override
    public Collection<Expense> getExpenses() {
        return null;
    }

    @Override
    public Optional<Expense> getExpense(long id) {
        return repository.get(id);
    }

    @Override
    public Collection<Expense> getExpensesBy(Long userId) {
        return repository.getExpensesBy(userId);
    }
}
