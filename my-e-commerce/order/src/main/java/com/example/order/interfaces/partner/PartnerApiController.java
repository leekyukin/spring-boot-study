package com.example.order.interfaces.partner;

import com.example.order.application.partner.PartnerFacade;
import com.example.order.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/partners")
@RestController
public class PartnerApiController {
    private final PartnerFacade partnerFacade;

    @PostMapping
    public CommonResponse registerPartner(@RequestBody @Valid PartnerDto.RegisterRequest request) {
        var command = request.toCommand();
        var partnerInfo = partnerFacade.registerPartner(command);
        var response = new PartnerDto.RegisterResponse(partnerInfo);
        return CommonResponse.success(response);
    }
}
