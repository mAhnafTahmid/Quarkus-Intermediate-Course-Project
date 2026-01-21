package org.agoncal.quarkus.jpa;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
class CustomerRepository {

    @Inject
    EntityManager em;

    public void persist(Customer customer) {
        em.persist(customer);
    }

    public Customer findById(Long id) {
        return em.find(Customer.class, id);
    }
}
