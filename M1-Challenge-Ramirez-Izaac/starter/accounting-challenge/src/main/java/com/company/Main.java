package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        //update this
        List<Customer> customers = new ArrayList<>();

        for (String[] data : customerData) {
            int id = Integer.parseInt(data[0]);
            String name = data[1];
            int charge = Integer.parseInt(data[2]);
            String chargeDate = data[3];

            //create a reference of a customer to check if the customer already exist in the customers
            //array list
            Customer customer = null;
            for (Customer existingCustomer : customers) {
                if (existingCustomer.getId() == id) {
                    customer = existingCustomer;
                    break;
                }
            }

            //if the customer doesn't exist create the customer
            //set its id, name, and add it to the customers list
            if (customer == null) {
                customer = new Customer();
                customer.setId(id);
                customer.setName(name);
                customers.add(customer);
            }

            //after determining if the customer already exist or if it needs to be created
            //create a new account record so we made add the record to the customers charges list in customer.java
            AccountRecord accountRecord = new AccountRecord();
            accountRecord.setCharge(charge);
            accountRecord.setChargeDate(chargeDate);
            customer.getCharges().add(accountRecord);
        }

        System.out.println("Positive accounts:");
        for (Customer customer : customers) {
            if (customer.getBalance() >= 0) {
                System.out.println(customer);
            }
        }

        System.out.println("Negative accounts:");
        for (Customer customer : customers) {
            if (customer.getBalance() < 0) {
                System.out.println(customer);
            }
        }
    }
}
