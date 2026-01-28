package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.agoncal.quarkus.jpa.Customer;
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
        assertTrue(repository.listAllDans().size() <= repository.count());
        Customer customer = new Customer("firstname", "lastname", "email");

        repository.persist(customer);
        Assertions.assertNotNull(customer.getId());

        customer = repository.findById(customer.getId());
        assertEquals("firstname", customer.getFirstName());
    }

}