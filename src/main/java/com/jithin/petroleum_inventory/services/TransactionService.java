package com.jithin.petroleum_inventory.services;

import com.jithin.petroleum_inventory.respositories.FuelRepository;
import com.jithin.petroleum_inventory.respositories.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    TransactionRepository transactionRepository;
    FuelRepository fuelRepository;

    public TransactionService(TransactionRepository transactionRepository, FuelRepository fuelRepository) {
        this.transactionRepository = transactionRepository;
        this.fuelRepository = fuelRepository;
    }
}
