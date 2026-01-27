package org.agoncal.quarkus.panache.model;

import java.time.Instant;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_purchase_order_lines")
public class OrderLine extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name = "item_fk")
    public Item item;

    @Column(nullable = false)
    public Integer quantity;

    @ManyToOne
    @JoinColumn(name = "purchase_order_fk")
    public PurchaseOrder purchaseOrder;

    @Column(name = "created_date", nullable = false)
    public Instant createdDate = Instant.now();

}
