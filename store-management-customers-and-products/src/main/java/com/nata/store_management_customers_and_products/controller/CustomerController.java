package com.nata.store_management_customers_and_products.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nata.store_management_customers_and_products.dto.CustomerDtos.CustomerDTO;
import com.nata.store_management_customers_and_products.service.CustomerService;

import jakarta.validation.Valid;

import java.util.List;

@Tag(name = "Customers", description = "Customer-related operations")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Operation(summary = "Create a new customer")
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.saveCustomer(customerDTO));
    }

    @Operation(summary = "List all customers")
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomer(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomers());
    }

    @Operation(summary = "Find a customer by ID")
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findCustomerById(
            @Parameter(description = "ID of the customer")
            @PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findById(id));
    }
    @Operation(summary = "Update customer details by ID")
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomerById(
            @Parameter(description = "ID of the customer")
            @PathVariable("id") Long id,
            @RequestBody @Valid CustomerDTO customerDTO){
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerService.updateCustomerFields(id,customerDTO));
    }

    @Operation(summary = "Delete a customer by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(
            @Parameter(description = "ID of the customer")
            @PathVariable("id") Long id){
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
