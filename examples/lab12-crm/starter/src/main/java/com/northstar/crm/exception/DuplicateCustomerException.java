package com.northstar.crm.exception;

public class DuplicateCustomerException extends RuntimeException {
    public DuplicateCustomerException(String customerId) {
        super("Customer with id " + customerId + " already exists");
    }
}
