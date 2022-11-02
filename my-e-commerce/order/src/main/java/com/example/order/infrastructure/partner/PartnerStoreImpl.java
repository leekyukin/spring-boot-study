package com.example.order.infrastructure.partner;

import com.example.order.domain.partner.Partner;
import com.example.order.domain.partner.PartnerStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PartnerStoreImpl implements PartnerStore {
    private final PartnerRepository partnerRepository;

    @Override
    public Partner store(Partner partner) {
        if (StringUtils.isEmpty(partner.getPartnerToken())) throw new IllegalArgumentException("partner.getPartnerToken()");
        if (StringUtils.isEmpty(partner.getPartnerName())) throw new IllegalArgumentException("partner.getPartnerName()");
        if (StringUtils.isEmpty(partner.getBusinessNo())) throw new IllegalArgumentException("partner.getBusinessNo()");
        if (StringUtils.isEmpty(partner.getEmail())) throw new IllegalArgumentException("partner.getEmail()");
        if (partner.getStatus() == null) throw new IllegalArgumentException("partner.getStatus()");

        return partnerRepository.save(partner);
    }
}
