package com.kukit.platform.expenses.domain.exceptions;

public class ExpenseDoesNotExists extends RuntimeException {
    public ExpenseDoesNotExists(String message) {
        super(message);
    }
}
