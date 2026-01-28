package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.agoncal.quarkus.panache.model.Publisher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

@QuarkusTest
class PublisherRepositoryTest {

    @Test
    @TestTransaction
    public void shouldCreateAndFindACustomer() throws SQLException {

        long count = Publisher.count();
        int listAll = Publisher.listAll().size();
        assertEquals(count, listAll);
        Publisher publisher = new Publisher("name");

        Publisher.persist(publisher);
        Assertions.assertNotNull(publisher.id);

        assertEquals(count + 1, Publisher.count());

        publisher = Publisher.findById(publisher.id);
        publisher = Publisher.findByName(publisher.name).orElseThrow(EntityNotFoundException::new);
        assertEquals("name", publisher.name);
        assertTrue(Publisher.findContainName("name").size() > 0);

        Publisher.deleteById(publisher.id);
        assertEquals(count, Publisher.count());
    }
}