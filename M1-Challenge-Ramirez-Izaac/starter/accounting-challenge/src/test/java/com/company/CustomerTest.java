package com.company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CustomerTest {
    private Customer customer;

    @BeforeEach
    public void setup() {
        customer = new Customer();
    }

    @Test
    public void testGetBalanceWithNoCharges() {
        int expectedBalance = 0;
        int actualBalance = customer.getBalance();
        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void testGetBalanceWithCharges() {
        AccountRecord testCharge1 = new AccountRecord();
        testCharge1.setCharge(20000);
        customer.getCharges().add(testCharge1);

        AccountRecord testCharge2 = new AccountRecord();
        testCharge2.setCharge(-15000);
        customer.getCharges().add(testCharge2);

        int expectedBalance = 5000;
        int actualBalance = customer.getBalance();

        assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void testToString(){
        customer.setId(1);
        customer.setName("Wayne Enterprises");

        String expectedString = "Customer ID: 1, Name: Wayne Enterprises, Balance: 0";
        String actualString = customer.toString();
        assertEquals(expectedString, actualString);
    }

}
