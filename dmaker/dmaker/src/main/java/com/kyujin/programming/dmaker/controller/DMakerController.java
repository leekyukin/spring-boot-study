package com.kyujin.programming.dmaker.controller;

import com.kyujin.programming.dmaker.dto.CreateDeveloper;
import com.kyujin.programming.dmaker.entity.Developer;
import com.kyujin.programming.dmaker.repository.DeveloperRepository;
import com.kyujin.programming.dmaker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public List<String> getAllDevelopers() {
        // GET /create-developers HTTP/1.1

        log.info("GET /create-developers HTTP/1.1");

        return Arrays.asList("Kyukin", "Jobs", "Bill");
    }

    @PostMapping("/create-developer")
    public List<Developer> createDevelopers(
           @Valid @RequestBody CreateDeveloper.Request request
    ) {
        // GET /developers HTTP/1.1
        log.info("request : {}", request);

        dMakerService.createDeveloper(request);

        return developerRepository.findAll();
    }

}
