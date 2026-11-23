package com.jithin.petroleum_inventory.controllers;

import com.jithin.petroleum_inventory.entities.Fuel;
import com.jithin.petroleum_inventory.respositories.FuelRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/fuels")
public class FuelController {

    FuelRepository fuelRepository;

    public FuelController(FuelRepository fuelRepository){
        this.fuelRepository = fuelRepository;
    }

    @PostMapping
    public ResponseEntity<Fuel> createFuel(@RequestBody Fuel fuel) {
        Fuel savedFuel = fuelRepository.save(fuel);
        return ResponseEntity.ok(savedFuel);
    }

    // GET API to see all fuels (useful for testing)
    @GetMapping
    public ResponseEntity<List<Fuel>> getAllFuels() {
        return ResponseEntity.ok(fuelRepository.findAll());
    }
}
