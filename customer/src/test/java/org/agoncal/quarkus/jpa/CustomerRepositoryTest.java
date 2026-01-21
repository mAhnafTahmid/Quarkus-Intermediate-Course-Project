package org.agoncal.quarkus.jpa;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

@QuarkusTest
class CustomerRepositoryTest {

    @Inject
    CustomerRepository repository;

    @Test
    @TestTransaction
    public void shouldCreateAndFindACustomer() throws SQLException {
        Customer customer = new Customer("firstname", "lastname", "email");

        repository.persist(customer);
        Assertions.assertNotNull(customer.getId());

        customer = repository.findById(customer.getId());
        assertEquals("firstname", customer.getFirstName());
    }

}