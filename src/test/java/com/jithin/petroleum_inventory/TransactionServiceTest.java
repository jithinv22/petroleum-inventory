package com.jithin.petroleum_inventory;

import com.jithin.petroleum_inventory.Enums.FuelFlowStatus;
import org.junit.jupiter.api.Test;


public class TransactionServiceTest {

    @Test
    public void testFuelStatusValidation(){
        String value = String.valueOf(FuelFlowStatus.IN);
        System.out.println(value+" "+"IN");
    }
}
