package com.nata.store_management_customers_and_products.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomerException {

    public static ResponseStatusException notfound(){
        return new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer not found!");
    }

}
