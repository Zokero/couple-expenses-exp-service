package com.example.expenses.application;


import com.example.expenses.domain.ports.Repository;
import com.example.expenses.infrastructure.InMemoryRepository;

public final class ExpensesSystemConfiguration {

    public static ExpensesSystem expensesSystem(Repository repository) {
        return Expenses.newInstance(repository);
    }

    public static ExpensesSystem expensesSystem() {
        return expensesSystem(new InMemoryRepository());
    }

}
