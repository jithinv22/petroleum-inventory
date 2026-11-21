package com.jithin.petroleum_inventory.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "fuels") // This will be the exact name of the table in PostgreSQL
public class Fuel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tells Postgres to auto-increment this ID
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // e.g., "Diesel", "Petrol 95"

    @Column(nullable = false)
    private BigDecimal pricePerLiter;

    @Column(nullable = false)
    private Double stockLiters;

    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPricePerLiter() {
        return pricePerLiter;
    }

    public void setPricePerLiter(BigDecimal pricePerLiter) {
        this.pricePerLiter = pricePerLiter;
    }

    public Double getStockLiters() {
        return stockLiters;
    }

    public void setStockLiters(Double stockLiters) {
        this.stockLiters = stockLiters;
    }
}