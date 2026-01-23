package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.agoncal.quarkus.panache.model.Publisher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

@QuarkusTest
class PublisherRepositoryTest {

    @Test
    @TestTransaction
    public void shouldCreateAndFindACustomer() throws SQLException {
        Publisher publisher = new Publisher("name");

        Publisher.persist(publisher);
        Assertions.assertNotNull(publisher.id);

        publisher = Publisher.findById(publisher.id);
        assertEquals("name", publisher.name);
    }
}