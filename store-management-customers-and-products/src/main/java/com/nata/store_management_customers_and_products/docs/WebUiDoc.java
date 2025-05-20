package com.nata.store_management_customers_and_products.docs;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Store Manager API",
                version = "1.0",
                description = "API to manage clients and products",
                contact = @Contact(
                        name = "Natã Marques",
                        email = "nmolinamarques@gmail.com",
                        url = "https://github.com/NataMarques08"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"
                )
        )
)
public class WebUiDoc {
}
