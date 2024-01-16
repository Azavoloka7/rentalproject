package com.zavoloka.rental.repository;

import com.zavoloka.rental.model.RentalTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalTransactionRepository extends JpaRepository<RentalTransaction, Long> {
    // Можна додати додаткові методи для вибору транзакцій за певними критеріями, якщо потрібно
}
