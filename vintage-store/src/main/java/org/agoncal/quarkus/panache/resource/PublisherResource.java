package org.agoncal.quarkus.panache.resource;

import java.util.List;

import org.agoncal.quarkus.panache.model.Publisher;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/publishers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PublisherResource {
    @GET
    @Path("{id}")
    public Publisher findPublisherById(@PathParam("id") Long id) {
        return (Publisher) Publisher.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    public List<Publisher> listAllArtists() {
        return Publisher.listAll();
    }
}
