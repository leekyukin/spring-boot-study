package com.study.redisTest;

import com.study.redisTest.dto.CreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CrudController {

    private final RedisService redisService;

    @PostMapping
    public void create(
            @RequestBody CreateRequestDto request
    ) {
        redisService.setData(request.getKey(), request.getValue());
    }

    @GetMapping("/{key}")
    public String readAll(
            @PathVariable String key
    ) {
        return redisService.getData(key);
    }

    @PutMapping
    public void update(
            @RequestBody CreateRequestDto request
    ) {
        redisService.updateValue(request.getKey(), request.getValue());
    }
}
