package com.nata.store_management_customers_and_products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nata.store_management_customers_and_products.dto.CustomerDtos.CustomerDTO;
import com.nata.store_management_customers_and_products.service.CustomerService;

import jakarta.validation.Valid;

import java.util.List;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.saveCustomer(customerDTO));
    }
    
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomer(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findCustomerById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomerById(@PathVariable("id") Long id,
                                                          @RequestBody @Valid CustomerDTO customerDTO){
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerService.updateCustomerFields(id,customerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id){
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
