package com.jithin.petroleum_inventory.controllers;

import com.jithin.petroleum_inventory.entities.Transaction;
import com.jithin.petroleum_inventory.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/transactions")
public class TransactionController {
    public final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping("/fuel/{fuelId}")
    public ResponseEntity<Transaction> createTransaction(
            @PathVariable Long fuelId,
            @RequestBody Transaction transaction) {

        Transaction savedTransaction = transactionService.createTransaction(fuelId, transaction);
        return ResponseEntity.ok(savedTransaction);
    }
}
