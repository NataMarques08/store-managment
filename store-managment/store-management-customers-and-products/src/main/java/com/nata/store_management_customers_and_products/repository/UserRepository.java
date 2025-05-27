package com.nata.store_management_customers_and_products.repository;

import com.nata.store_management_customers_and_products.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
