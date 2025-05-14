package com.nata.store_management_customers_and_products.mapper;

import org.mapstruct.Mapper;

import com.nata.store_management_customers_and_products.dto.CustomerDtos.CustomerDTO;
import com.nata.store_management_customers_and_products.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {


    CustomerDTO convertEntityToDTO(Customer customer);

    Customer convertDTOToEntity(CustomerDTO customerDTO);
}
