package com.study.redisTest;

import com.study.redisTest.dto.CreateRequestDto;
import com.study.redisTest.dto.UpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class CrudController {

    private final RedisService redisService;

    @PostMapping
    public void set(
            @RequestBody CreateRequestDto request
    ) {
        redisService.setData(request.getKey(), request.getValue());
    }

    @GetMapping("/get/{key}")
    public String get(
            @PathVariable String key
    ) {
        return redisService.getData(key);
    }

    @PutMapping
    public void rename(
            @RequestBody UpdateRequestDto request
    ) {
        redisService.updateValue(request.getKey(), request.getNewKey());
    }

    @DeleteMapping("/{key}")
    public void delete(
            @PathVariable String key
    ) {
        redisService.delete(key);
    }

    @GetMapping("/keys/{pattern}")
    public Set<String> keys(
            @PathVariable String pattern
    ) {
        return redisService.keys(pattern);
    }
}
