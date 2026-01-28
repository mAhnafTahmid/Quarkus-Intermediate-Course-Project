package org.agoncal.quarkus.panache.model;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_publishers")
public class Publisher extends PanacheEntity {

    @Column(length = 50, nullable = false)
    public String name;

    public static Optional<Publisher> findByName(String name) {
        return find("name", name).firstResultOptional();
    }

    public static List<Publisher> findContainName(String name) {
        return Publisher.list("name like ?1", "%" + name + "%");
    }

    @Column(name = "created_date", nullable = false)
    public Instant createdDate = Instant.now();

    public Publisher() {
    }

    public Publisher(String name) {
        this.name = name;
    }

}
