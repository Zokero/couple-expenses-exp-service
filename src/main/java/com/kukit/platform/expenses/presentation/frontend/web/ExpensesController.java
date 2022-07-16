package com.kukit.platform.expenses.presentation.frontend.web;

import com.kukit.platform.expenses.application.ExpensesSystem;
import com.kukit.platform.expenses.domain.Expense;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/expenses")
@Slf4j
public class ExpensesController {

    ExpensesSystem expensesSystem;

    public ExpensesController(ExpensesSystem expensesSystem) {
        this.expensesSystem = expensesSystem;
    }

    @PostMapping
    void saveSingleExpense(@RequestBody Expense expense) {
        log.info("Save new Expense");
        expensesSystem.addExpense(expense);
    }

    @GetMapping("/{id}")
    Collection<Expense> getExpenseById(@PathVariable("id") Long id) {
        log.info("get Expense with id= " + id);
        return expensesSystem.getExpensesBy(id);
    }

    @GetMapping("/")
    Collection<Expense> getAllExpenses() {
        log.info("fetch all expenses");
        return expensesSystem.getExpenses();
    }
}
