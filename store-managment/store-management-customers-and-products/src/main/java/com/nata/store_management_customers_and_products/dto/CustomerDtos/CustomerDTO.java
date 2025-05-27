package com.nata.store_management_customers_and_products.dto.CustomerDtos;

import java.math.BigDecimal;

public record CustomerDTO (
    String name,    
    String lastname,
    String email,
    String phone,
    String address,
    String city,
    String state,
    BigDecimal creditlimit
){


    
}


    
    


