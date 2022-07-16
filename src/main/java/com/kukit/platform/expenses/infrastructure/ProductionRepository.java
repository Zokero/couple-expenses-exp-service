package com.kukit.platform.expenses.infrastructure;

import com.kukit.platform.expenses.domain.Expense;
import com.kukit.platform.expenses.domain.exceptions.ExpenseDoesNotExists;
import com.kukit.platform.expenses.domain.ports.Repository;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ProductionRepository implements Repository {

    private ExpensesRepository repository;

    @Override
    public void editExpense(Expense expense) {
        Optional<Expense> byId = repository.findById(expense.getId());
        if(byId.isPresent()){
            repository.update(expense.getId(),expense.getDateTime(), expense.getProductName(), expense.getStoreName());
        }else {
            throw new ExpenseDoesNotExists("Expense with id=" + expense.getId() + "does not exists");
        }
    }

    @Override
    public void add(Expense expense) {
        repository.save(expense);
    }

    @Override
    public Optional<Expense> get(Long expenseId) {
        return repository.findById(expenseId);
    }

    @Override
    public void remove(Long expenseId) {
        repository.deleteById(expenseId);
    }

    @Override
    public Collection<Expense> getAll() {
        return repository.findAll();
    }

    @Override
    public Collection<Expense> getExpensesBy(Long userId) {
        return repository.findAllById(List.of(userId));
    }
}
