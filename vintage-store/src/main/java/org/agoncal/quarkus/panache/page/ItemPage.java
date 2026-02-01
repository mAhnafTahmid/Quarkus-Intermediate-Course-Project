package org.agoncal.quarkus.panache.page;

import java.util.List;

import org.agoncal.quarkus.panache.model.Book;
import org.agoncal.quarkus.panache.model.Item;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

// @Path("page/items")
// @Produces(MediaType.TEXT_HTML)
// public class ItemPage {

//     @CheckedTemplate
//     public static class Templates {
//         public static native TemplateInstance book(Book book);

//         public static native TemplateInstance books(List<Book> books);
//     }

//     @GET
//     @Path("/books/{id}")
//     public TemplateInstance showBookById(@PathParam("id") Long id) {
//         return Templates.book(Book.findById(id));
//     }

//     @GET
//     @Path("/books")
//     public TemplateInstance showAllBooks() {
//         return Templates.books(Book.listAll());
//     }
// }

@Path("page/items")
@Produces(MediaType.TEXT_HTML)
public class ItemPage {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance book(Book book);

        public static native TemplateInstance books(List<Book> books);
    }

    @GET
    @Path("/books/{id}")
    public TemplateInstance showBookById(@PathParam("id") Long id) {
        // Query the t_items table where dtype = 'Book' and id = :id
        Book book = Item.find("dtype = ?1 and id = ?2", "Book", id)
                .firstResult(); // returns null if not found
        return Templates.book(book);
    }

    @GET
    @Path("/books")
    public TemplateInstance showAllBooks() {
        // Query all items where dtype = 'Book' and map to Book
        List<Book> books = Book.listAll();
        return Templates.books(books);
    }
}
