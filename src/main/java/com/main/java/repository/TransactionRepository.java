package com.main.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.java.domain.Transaction;

/**
 * This is the JPA repository.
 */

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
