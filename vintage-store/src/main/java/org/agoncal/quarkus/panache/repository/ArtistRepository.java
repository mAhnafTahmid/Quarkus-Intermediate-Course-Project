package org.agoncal.quarkus.panache.repository;

import org.agoncal.quarkus.jdbc.Artist;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArtistRepository implements PanacheRepository<Artist> {

}
