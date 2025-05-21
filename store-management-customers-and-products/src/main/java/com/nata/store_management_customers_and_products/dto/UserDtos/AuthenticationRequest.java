package com.nata.store_management_customers_and_products.dto.UserDtos;

public record AuthenticationRequest(
        String username,
        String password
) {
}
