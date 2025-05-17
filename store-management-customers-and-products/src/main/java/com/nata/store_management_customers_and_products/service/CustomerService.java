package com.nata.store_management_customers_and_products.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nata.store_management_customers_and_products.dto.CustomerDtos.CustomerDTO;
import com.nata.store_management_customers_and_products.mapper.CustomerMapper;
import com.nata.store_management_customers_and_products.model.Customer;
import com.nata.store_management_customers_and_products.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

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


    public List<CustomerDTO> getAllCustomers(){
        List<Customer> customer = customerRepository.findAll();
        return customerMapper.convertEntityListToDTO(customer);
    }

    public CustomerDTO findById(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        return customerMapper.convertEntityToDTO(customer.orElse(null));
    }

    public CustomerDTO updateCustomerFields(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        
    }

}
