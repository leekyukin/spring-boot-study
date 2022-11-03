package com.example.order.domain.item.item.service;

import com.example.order.domain.item.item.ItemCommand;
import com.example.order.domain.item.item.ItemInfo;

public interface ItemService {
    String registerItem(ItemCommand.RegisterItemRequest request, String partnerToken);
    void changeOnSale(String itemToken);
    void changeEndOfSale(String itemToken);
    ItemInfo.Main retrieveItemInfo(String itemToken);
}
