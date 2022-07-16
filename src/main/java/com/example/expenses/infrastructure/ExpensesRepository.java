package com.example.expenses.infrastructure;

import com.example.expenses.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ExpensesRepository extends JpaRepository<Expense, Long> {
    @Modifying
    @Query("UPDATE expenses SET store_name = ?4, product_name = ?3 dateTime - ?2  WHERE id = ?1")
    void update(Long id, LocalDateTime dateTime, String productName, String storeName);

}
