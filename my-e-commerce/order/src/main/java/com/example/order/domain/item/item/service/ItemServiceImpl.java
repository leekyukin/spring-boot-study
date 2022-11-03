package com.example.order.domain.item.item.service;

import com.example.order.domain.item.item.ItemCommand;
import com.example.order.domain.item.item.ItemInfo;
import com.example.order.domain.item.item.designing.ItemStore;
import com.example.order.domain.item.itemOption.ItemOption;
import com.example.order.domain.item.itemOption.designing.ItemOptionStore;
import com.example.order.domain.item.itemOptionGroup.ItemOptionGroup;
import com.example.order.domain.item.itemOptionGroup.designing.ItemOptionGroupStore;
import com.example.order.domain.partner.designing.PartnerReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService{
    private final ItemStore itemStore;
    private final PartnerReader partnerReader;
    private final ItemOptionGroupStore itemOptionGroupStore;
    private final ItemOptionStore itemOptionStore;

    @Override
    public String registerItem(ItemCommand.RegisterItemRequest command, String partnerToken) {
        var partner = partnerReader.getPartner(partnerToken);
        var partnerId = partner.getId();

        var initItem = command.toEntity(partnerId);
        var item = itemStore.store(initItem);

        command.getItemOptionGroupRequestList().forEach(requestItemOptionGroup -> {
            var initItemOptionGroup = ItemOptionGroup.builder()
                .item(item)
                .ordering(requestItemOptionGroup.getOrdering())
                .itemOptionGroupName(requestItemOptionGroup.getItemOptionGroupName())
                .build();
            var itemOptionGroup = itemOptionGroupStore.store(initItemOptionGroup);

            requestItemOptionGroup.getRegisterItemOptionRequestList().forEach(requestItemOption -> {
                var initItemOption = ItemOption.builder()
                    .itemOptionGroup(itemOptionGroup)
                    .ordering(requestItemOption.getOrdering())
                    .itemOptionName(itemOptionGroup.getItemOptionGroupName())
                    .itemOptionPrice(requestItemOption.getItemOptionPrice())
                    .build();

                itemOptionStore.store(initItemOption);
            });
        });

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
