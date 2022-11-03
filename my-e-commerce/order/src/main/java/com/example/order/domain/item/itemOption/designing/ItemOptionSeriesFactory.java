package com.example.order.domain.item.itemOption.designing;

import com.example.order.domain.item.item.Item;
import com.example.order.domain.item.item.ItemCommand;
import com.example.order.domain.item.itemOptionGroup.ItemOptionGroup;

import java.util.List;

public interface ItemOptionSeriesFactory {
    List<ItemOptionGroup> store(ItemCommand.RegisterItemRequest command, Item item);
}