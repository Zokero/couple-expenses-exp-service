package com.kukit.platform.expenses.domain.exceptions;

public class ExpenseAlreadyExists extends RuntimeException{
    public ExpenseAlreadyExists(String message) {
        super(message);
    }
}
