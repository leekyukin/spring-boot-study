package com.kyujin.programming.dmaker.controller;

import com.kyujin.programming.dmaker.entity.Developer;
import com.kyujin.programming.dmaker.repository.DeveloperRepository;
import com.kyujin.programming.dmaker.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DMakerController {

    private final DMakerService dMakerService;
    private final DeveloperRepository developerRepository;

    @GetMapping("/developers")
    public List<String> getAllDevelopers() {
        // GET /create-developers HTTP/1.1

        log.info("GET /create-developers HTTP/1.1");

        return Arrays.asList("Kyukin", "Jobs", "Bill");
    }

    @GetMapping("/create-developer")
    public List<Developer> createDevelopers() {
        // GET /developers HTTP/1.1
        log.info("GET /create-developer HTTP/1.1");

        dMakerService.createDeveloper();

        return developerRepository.findAll();
    }

}
