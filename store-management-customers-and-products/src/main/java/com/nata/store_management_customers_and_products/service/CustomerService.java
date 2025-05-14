package com.nata.store_management_customers_and_products.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nata.store_management_customers_and_products.dto.CustomerDtos.CustomerDTO;
import com.nata.store_management_customers_and_products.mapper.CustomerMapper;
import com.nata.store_management_customers_and_products.model.Customer;
import com.nata.store_management_customers_and_products.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {


    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustomerRepository customerRepository;


    public CustomerDTO saveCustomer(CustomerDTO customerDTO){
        Customer customer = customerMapper.convertDTOToEntity(customerDTO);
        customer = customerRepository.save(customer);
        return customerMapper.convertEntityToDTO(customer);
    }

    public ResponseEntity<List<CustomerDTO>> getAllCustomer(){

    }


}
