package com.nata.store_management_customers_and_products.service;


import com.nata.store_management_customers_and_products.exceptions.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import com.nata.store_management_customers_and_products.dto.CustomerDtos.CustomerDTO;
import com.nata.store_management_customers_and_products.mapper.CustomerMapper;
import com.nata.store_management_customers_and_products.model.Customer;
import com.nata.store_management_customers_and_products.repository.CustomerRepository;

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


    public Page<CustomerDTO> getAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable).map(customerMapper::convertEntityToDTO);
    }

    public CustomerDTO findById(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        return customerMapper.convertEntityToDTO(customer.orElse(null));
    }

    public CustomerDTO updateCustomerFields(Long id, CustomerDTO customerDTO){
        Customer customer = customerRepository.findById(id).orElseThrow(CustomerException::notfound);

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
        Customer customer = customerRepository.findById(id)
                .orElseThrow(CustomerException::notfound);
        customerRepository.delete(customer);
    }

}
