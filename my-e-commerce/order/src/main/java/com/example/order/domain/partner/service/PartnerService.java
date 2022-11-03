package com.example.order.domain.partner.service;

import com.example.order.domain.partner.PartnerCommand;
import com.example.order.domain.partner.PartnerInfo;

public interface PartnerService {
    // Command : 명령
    // Criteria : 조회
    // Info : 객체에 대한 리턴

    PartnerInfo registerPartner(PartnerCommand command);
    PartnerInfo getPartner(String partnerToken);
    PartnerInfo enablePartner(String partnerToken);
    PartnerInfo disablePartner(String partnerToken);
}
