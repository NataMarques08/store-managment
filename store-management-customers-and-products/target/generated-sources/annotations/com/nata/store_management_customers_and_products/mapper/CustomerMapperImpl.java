package com.nata.store_management_customers_and_products.mapper;

import com.nata.store_management_customers_and_products.dto.CustomerDtos.CustomerDTO;
import com.nata.store_management_customers_and_products.model.Customer;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-13T22:20:57-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.15 (Amazon.com Inc.)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer convertDTOToEntity(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        if ( customerDTO.creditlimit() != null ) {
            customer.setCreditlimit( BigDecimal.valueOf( customerDTO.creditlimit() ) );
        }
        customer.setName( customerDTO.name() );
        customer.setLastname( customerDTO.lastname() );
        customer.setEmail( customerDTO.email() );
        customer.setPhone( customerDTO.phone() );
        customer.setAddress( customerDTO.address() );
        customer.setCity( customerDTO.city() );
        customer.setState( customerDTO.state() );

        return customer;
    }

    @Override
    public CustomerDTO convertEntityToDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        String name = null;
        String lastname = null;
        String email = null;
        String phone = null;
        String address = null;
        String city = null;
        String state = null;
        Double creditlimit = null;

        name = customer.getName();
        lastname = customer.getLastname();
        email = customer.getEmail();
        phone = customer.getPhone();
        address = customer.getAddress();
        city = customer.getCity();
        state = customer.getState();
        if ( customer.getCreditlimit() != null ) {
            creditlimit = customer.getCreditlimit().doubleValue();
        }

        CustomerDTO customerDTO = new CustomerDTO( name, lastname, email, phone, address, city, state, creditlimit );

        return customerDTO;
    }
}
