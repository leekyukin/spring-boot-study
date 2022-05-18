package com.practice.jparelationmapping.JPABookTest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    private int orderPrice;
    private int count;

    void setOrder(Order order) {
        if (this.getOrder() != null) {
            this.order.getOrderItems().remove(this);
        }
        this.order = order;
        this.order.getOrderItems().add(this);
    }

}
