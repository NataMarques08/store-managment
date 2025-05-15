package com.nata.store_management_customers_and_products.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.nata.store_management_customers_and_products.dto.CustomerDtos.CustomerDTO;
import com.nata.store_management_customers_and_products.model.Customer;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "creditlimit", source = "creditlimit")
    Customer convertDTOToEntity(CustomerDTO customerDTO);
    CustomerDTO convertEntityToDTO(Customer customer);
    default List<CustomerDTO> convertEntityListToDTO(List<Customer> customer){
        return customer.stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }
    
}
