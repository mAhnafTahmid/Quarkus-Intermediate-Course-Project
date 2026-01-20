package org.agoncal.quarkus.jdbc;

import io.quarkus.test.junit.QuarkusTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import jakarta.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
class ArtistRepositoryTest {

    @Inject
    ArtistRepository repository;

    @Test
    public void shouldCreateAndFindAnArtist() throws SQLException {
        Artist artist = new Artist("name", "bio");

        repository.persist(artist);
        Assertions.assertNotNull(artist.getId());

        artist = repository.findById(artist.getId());
        assertEquals("name", artist.getName());
    }

}