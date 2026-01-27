package org.agoncal.quarkus.panache.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class CD extends Item {

    @Column(name = "music_company")
    public String musicCompany;

    @Column(length = 100)
    public String genre;

    @OneToMany(mappedBy = "cd")
    public List<Track> tracks = new ArrayList<>();

}
