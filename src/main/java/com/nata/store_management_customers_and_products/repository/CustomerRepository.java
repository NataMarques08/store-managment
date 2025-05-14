package com.nata.store_management_customers_and_products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nata.store_management_customers_and_products.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
