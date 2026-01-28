package org.agoncal.quarkus.panache.repository;

import java.util.List;

import org.agoncal.quarkus.jpa.Customer;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {
    public List<Customer> listAllDans() {
        return list("firstName = 'Dan'", Sort.by("lastName"));
    }
}
