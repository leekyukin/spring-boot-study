package com.example.order.infrastructure.item;

import com.example.order.domain.item.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
