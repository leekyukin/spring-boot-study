package com.example.order.domain.partner.designing;

import com.example.order.domain.partner.Partner;

public interface PartnerReader {
    Partner getPartner(String partnerToken);
}
