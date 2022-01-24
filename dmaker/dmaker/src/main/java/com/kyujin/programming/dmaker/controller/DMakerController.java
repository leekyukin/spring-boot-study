package com.kyujin.programming.dmaker.controller;

import com.kyujin.programming.dmaker.dto.CreateDeveloper;
import com.kyujin.programming.dmaker.dto.DeveloperDetailDto;
import com.kyujin.programming.dmaker.dto.DeveloperDto;
import com.kyujin.programming.dmaker.dto.EditDeveloper;
import com.kyujin.programming.dmaker.entity.Developer;
import com.kyujin.programming.dmaker.repository.DeveloperRepository;
import com.kyujin.programming.dmaker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@ToString
public class DMakerController {

    private final DMakerService dMakerService;
    private final DeveloperRepository developerRepository;

    @GetMapping("/developers")
    public List<DeveloperDto> getAllDevelopers() {
        // GET /create-developers HTTP/1.1

        log.info("GET /create-developers HTTP/1.1");

        return dMakerService.getAllDevelopers();
    }

    @GetMapping("/developer/{memberId}")
    public DeveloperDetailDto getDeveloperDetail(
            @PathVariable String memberId
    ) {

        log.info("GET /developer HTTP/1.1");

        return dMakerService.getDeveloperDetail(memberId);
    }

    @PutMapping("/developer/{memberId}")
    public DeveloperDetailDto editDeveloper(
            @PathVariable String memberId,
            @Valid @RequestBody EditDeveloper.Request request
    ) {
        log.info("GET /developer HTTP/1.1");

        return dMakerService.editDeveloper(memberId, request);
    }

    @PostMapping("/create-developer")
    public CreateDeveloper.Response createDevelopers(
           @Valid @RequestBody CreateDeveloper.Request request
    ) {
        // GET /developers HTTP/1.1
        log.info("request : {}", request);

        return dMakerService.createDeveloper(request);
    }

}
