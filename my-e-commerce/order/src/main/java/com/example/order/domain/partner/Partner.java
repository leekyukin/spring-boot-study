package com.example.order.domain.partner;

import com.example.order.common.util.TokenGenerator;
import com.example.order.domain.AbstractEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@Slf4j
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "partners")
public class Partner extends AbstractEntity {
    private static final String PREFIX_PARTNER = "ptn_";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String partnerToken;
    private String partnerName;
    private String businessNo;
    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ENABLE("활성화"), DISABLE("비활성화");
        private final String description;
    }

    @Builder
    public Partner(String partnerName, String businessNo, String email) {

        if (StringUtils.isEmpty(partnerName)) throw new RuntimeException("empty partnerName");
        if (StringUtils.isEmpty(businessNo)) throw new RuntimeException("empty businessNo");
        if (StringUtils.isEmpty(email)) throw new RuntimeException("empty email");

        this.partnerToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_PARTNER);
        this.partnerName = partnerName;
        this.businessNo = businessNo;
        this.email = email;
        this.status = Status.ENABLE;
    }

    public void enable() {
        this.status = Status.ENABLE;
    }

    public void disable() {
        this.status = Status.DISABLE;
    }
}
