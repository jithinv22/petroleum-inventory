package com.jithin.petroleum_inventory.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Transaction type: e.g., "IN" (restock), "OUT" (sale)
    @Column(nullable = false)
    private String type;

    // Quantity of fuel involved in the transaction
    @Column(nullable = false)
    private Double amountLiters;

    // Total price of the transaction
    @Column(nullable = false)
    private BigDecimal totalPrice;

    // Record creation time, automatically generated
    @Column(nullable = false)
    private LocalDateTime transactionTime = LocalDateTime.now();

    // Foreign key association: points to the Fuel entity
    // Many transactions can correspond to one fuel type (ManyToOne)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fuel_id", nullable = false)
    private Fuel fuel;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Double getAmountLiters() { return amountLiters; }
    public void setAmountLiters(Double amountLiters) { this.amountLiters = amountLiters; }

    public BigDecimal getTotalPrice() { return totalPrice; }
    public void setTotalPrice(BigDecimal totalPrice) { this.totalPrice = totalPrice; }

    public LocalDateTime getTransactionTime() { return transactionTime; }
    public void setTransactionTime(LocalDateTime transactionTime) { this.transactionTime = transactionTime; }

    public Fuel getFuel() { return fuel; }
    public void setFuel(Fuel fuel) { this.fuel = fuel; }
}
