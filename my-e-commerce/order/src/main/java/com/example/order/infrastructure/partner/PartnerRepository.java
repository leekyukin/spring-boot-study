package com.example.order.infrastructure.partner;

import com.example.order.domain.partner.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartnerRepository extends JpaRepository<Partner, Long>  {
    Optional<Partner> findByPartnerToken(String partnerToken);
}
