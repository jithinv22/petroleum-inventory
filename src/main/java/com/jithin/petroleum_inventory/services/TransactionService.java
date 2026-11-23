package com.jithin.petroleum_inventory.services;

import com.jithin.petroleum_inventory.Enums.FuelFlowStatus;
import com.jithin.petroleum_inventory.entities.Fuel;
import com.jithin.petroleum_inventory.entities.Transaction;
import com.jithin.petroleum_inventory.respositories.FuelRepository;
import com.jithin.petroleum_inventory.respositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {
    TransactionRepository transactionRepository;
    FuelRepository fuelRepository;

    public TransactionService(TransactionRepository transactionRepository, FuelRepository fuelRepository) {
        this.transactionRepository = transactionRepository;
        this.fuelRepository = fuelRepository;
    }

    public Transaction createTransaction(Long fuelId, Transaction transactionRequest) {
        // 1. Find the fuel by ID
        Fuel fuel = fuelRepository.findById(fuelId)
                .orElseThrow(() -> new RuntimeException("Fuel not found with id: " + fuelId));

        // 2. Update the stock based on transaction type (IN = restock, OUT = sale)
        if (String.valueOf(FuelFlowStatus.IN).equalsIgnoreCase(transactionRequest.getType())) {
            fuel.setStockLiters(fuel.getStockLiters() + transactionRequest.getAmountLiters());
        } else if (String.valueOf(FuelFlowStatus.OUT).equalsIgnoreCase(transactionRequest.getType())) {
            if (fuel.getStockLiters() < transactionRequest.getAmountLiters()) {
                throw new RuntimeException("Not enough stock available!");
            }
            fuel.setStockLiters(fuel.getStockLiters() - transactionRequest.getAmountLiters());
        } else {
            throw new RuntimeException("Transaction type must be 'IN' or 'OUT'");
        }

        // 3. Save the updated fuel stock back to the database
        fuelRepository.save(fuel);

        // 4. Link the transaction to the fuel and set the time
        transactionRequest.setFuel(fuel);
        transactionRequest.setTransactionTime(LocalDateTime.now());

        // 5. Save the transaction to the database
        return transactionRepository.save(transactionRequest);
    }
}
