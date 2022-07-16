package com.kukit.platform.expenses.application;


import com.kukit.platform.expenses.domain.ports.Repository;
import com.kukit.platform.expenses.infrastructure.InMemoryRepository;

public final class ExpensesSystemConfiguration {

    public static ExpensesSystem expensesSystem(Repository repository) {
        return Expenses.newInstance(repository);
    }

    public static ExpensesSystem expensesSystem() {
        return expensesSystem(new InMemoryRepository());
    }

}
