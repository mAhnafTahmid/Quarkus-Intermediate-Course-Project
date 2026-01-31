package org.agoncal.quarkus.panache.resource;

import java.util.List;

import org.agoncal.quarkus.jdbc.Artist;
import org.agoncal.quarkus.panache.model.Publisher;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

@Path("/api/publishers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(Transactional.TxType.SUPPORTS)
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

    @Transactional(Transactional.TxType.REQUIRED)
    @POST
    public Response persisArtist(Publisher publisher, @Context UriInfo uriInfo) {
        Publisher.persist(publisher);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(publisher.id));
        return Response.created(builder.build()).build();
    }

    @Transactional
    @DELETE
    @Path("{id}")
    public void deleteArtist(@PathParam("id") Long id) {
        Publisher.deleteById(id);
    }
}
