package com.nata.store_management_customers_and_products.dto.UserDtos;

public record RegisterRequest(
        String username,
        String password,
        String role
) { }
