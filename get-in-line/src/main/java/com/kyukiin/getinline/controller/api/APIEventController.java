package com.kyukiin.getinline.controller.api;


import com.kyukiin.getinline.exception.GeneralException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/api")
@RestController
public class APIEventController {


    @GetMapping("/events")
    public List<String> getEvents() {
        throw new GeneralException("runtime 테스트 메세지");
//        return List.of("event1", "event2");
    }

    @PostMapping("/events")
    public Boolean createEvent() { return true; }

    @GetMapping("/event/{eventId}")
    public String getEvent(@PathVariable Integer eventId) { return "event " + eventId; }

    @PutMapping("/events/{eventId}")
    public Boolean modifyEvent(@PathVariable Integer eventId) { return true; }

    @DeleteMapping("/events/{eventId}")
    public Boolean removeEvent(@PathVariable Integer eventId) { return true; }
}
