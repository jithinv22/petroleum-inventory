package com.jithin.petroleum_inventory.respositories;

import com.jithin.petroleum_inventory.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}