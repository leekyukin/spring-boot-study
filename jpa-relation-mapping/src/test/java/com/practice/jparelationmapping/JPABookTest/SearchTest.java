package com.practice.jparelationmapping.JPABookTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
public class SearchTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    @Transactional
    void GraphSearchTest() {

        Member member = new Member();
        member.setName("이규진");

        Order order = new Order();
        order.setStatus(Order.OrderStatus.ORDER);
        order.setMember(member);

        System.out.println(">>>>> " + order.getMember());

        OrderItem orderItem = new OrderItem();
        orderItem.setCount(5);
        orderItem.setOrder(order);

        System.out.println(" ORDER ITEM >>> " + orderItem);
        System.out.println(" ORDER ITEM >>> " +  order.getOrderItems());

        System.out.println(" ORDER >>> " + order);
        System.out.println(" ORDER s>>> " + orderItem.getOrder());




    }
}
