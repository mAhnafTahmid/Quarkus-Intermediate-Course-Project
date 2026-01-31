package org.agoncal.quarkus.panache.resource;

import java.util.List;

import org.agoncal.quarkus.jpa.Customer;
import org.agoncal.quarkus.panache.repository.CustomerRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {
    @Inject
    CustomerRepository repository;

    @GET
    @Path("{id}")
    public Customer findArtistById(@PathParam("id") Long id) {
        return repository.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    public List<Customer> listAllArtists() {
        return repository.listAll();
    }
}
