package org.agoncal.quarkus.panache.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Book extends Item {

    @Column(length = 15)
    public String isbn;

    @Column(name = "nb_of_pages")
    public int nbOfPages;

    @Column(name = "publication_date")
    public LocalDate publicationDate;

    @Enumerated(EnumType.STRING)
    public Language language;

}
