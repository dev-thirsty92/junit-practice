package com.junitpractice.chapter02.tag;

import java.util.HashMap;

class CustomersRepository {

    HashMap<String, Customer> customers = new HashMap<>();

    boolean contains(String customerName) {
        return customers.containsKey(customerName);
    }

    void persist(Customer customer){
        customers.put(customer.getName(), customer);
    }
}
