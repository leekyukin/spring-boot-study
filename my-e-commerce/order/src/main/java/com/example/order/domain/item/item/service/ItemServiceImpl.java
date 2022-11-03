package com.example.order.domain.item.item.service;

import com.example.order.domain.item.item.ItemCommand;
import com.example.order.domain.item.item.ItemInfo;
import com.example.order.domain.item.item.designing.ItemStore;
import com.example.order.domain.item.itemOption.designing.ItemOptionSeriesFactory;
import com.example.order.domain.partner.designing.PartnerReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService{
    private final PartnerReader partnerReader;
    private final ItemStore itemStore;
    private final ItemOptionSeriesFactory itemOptionSeriesFactory;

    @Override
    public String registerItem(ItemCommand.RegisterItemRequest command, String partnerToken) {
        var partner = partnerReader.getPartner(partnerToken);
        var initItem = command.toEntity(partner.getId());
        var item = itemStore.store(initItem);
        itemOptionSeriesFactory.store(command, item);
        return item.getItemToken();
    }

    @Override
    public void changeOnSale(String itemToken) {

    }

    @Override
    public void changeEndOfSale(String itemToken) {

    }

    @Override
    public ItemInfo.Main retrieveItemInfo(String itemToken) {
        return null;
    }
}
