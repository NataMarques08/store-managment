package com.nata.store_management_customers_and_products.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.nata.store_management_customers_and_products.dto.CustomerDtos.CustomerDTO;
import com.nata.store_management_customers_and_products.mapper.CustomerMapper;
import com.nata.store_management_customers_and_products.model.Customer;
import com.nata.store_management_customers_and_products.repository.CustomerRepository;
import org.springframework.web.server.ResponseStatusException;

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

    public CustomerDTO updateCustomerFields(Long id, CustomerDTO customerDTO){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Customer not found!"
        ));

        customer.setName(customerDTO.name());
        customer.setLastname(customerDTO.lastname());
        customer.setEmail(customerDTO.email());
        customer.setPhone(customerDTO.phone());
        customer.setAddress(customerDTO.address());
        customer.setCity(customerDTO.city());
        customer.setState(customerDTO.state());
        customer.setCreditlimit(customerDTO.creditlimit());

        return customerMapper.convertEntityToDTO(customerRepository.save(customer));
    }

    public void delete(Long id){
        if (!customerRepository.existsById(id)) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Customer not found");
        customerRepository.deleteById(id);
    }

}
