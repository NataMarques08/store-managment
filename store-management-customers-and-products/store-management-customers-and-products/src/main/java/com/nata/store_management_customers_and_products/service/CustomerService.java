package com.nata.store_management_customers_and_products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nata.store_management_customers_and_products.dto.CustomerDtos.CustomerDTO;
import com.nata.store_management_customers_and_products.mapper.CustomerMapper;
import com.nata.store_management_customers_and_products.model.Customer;
import com.nata.store_management_customers_and_products.repository.CustomerRepository;

@Service
public class CustomerService {


    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustomerRepository customerRepository;


    public Customer saveCustomer(CustomerDTO customerDTO){
        return customerRepository.save(customerMapper.convertDTOToEntity(customerDTO));
    }


}
