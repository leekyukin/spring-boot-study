package com.example.order.infrastructure.item;

import com.example.order.domain.item.item.Item;
import com.example.order.domain.item.item.ItemCommand;
import com.example.order.domain.item.itemOption.designing.ItemOptionSeriesFactory;
import com.example.order.domain.item.itemOption.designing.ItemOptionStore;
import com.example.order.domain.item.itemOptionGroup.ItemOptionGroup;
import com.example.order.domain.item.itemOptionGroup.designing.ItemOptionGroupStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class ItemOptionSeriesFactoryImpl implements ItemOptionSeriesFactory {
    private final ItemOptionGroupStore itemOptionGroupStore;
    private final ItemOptionStore itemOptionStore;


    @Override
    public List<ItemOptionGroup> store(ItemCommand.RegisterItemRequest command, Item item) {
        var itemOptionGroupRequestList = command.getItemOptionGroupRequestList();
        if (CollectionUtils.isEmpty(itemOptionGroupRequestList)) return Collections.emptyList();

        return itemOptionGroupRequestList.stream()
            .map(requestItemOptionGroup -> {
                var initItemOptionGroup = requestItemOptionGroup.toEntity(item);
                var itemOptionGroup = itemOptionGroupStore.store(initItemOptionGroup);

                requestItemOptionGroup.getItemOptionRequestList().forEach(requestItemOption -> {
                    var initItemOption = requestItemOption.toEntity(itemOptionGroup);
                    itemOptionStore.store(initItemOption);
                });

                return itemOptionGroup;
            }).collect(Collectors.toList());
    }
}
