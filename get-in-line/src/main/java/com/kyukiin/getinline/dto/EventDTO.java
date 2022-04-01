package com.kyukiin.getinline.dto;

import com.kyukiin.getinline.constant.EventStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record EventDTO (
        Long placeId,
        String eventName,
        EventStatus eventStatus,
        LocalDateTime eventStartDatetime,
        LocalDateTime eventEndDatetime,
        Integer capacity,
        Integer currentNumberOfPeople,
        String memo,
        LocalDateTime createAt,
        LocalDateTime modifiedAt
) {
    public static EventDTO of(
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDatetime,
            LocalDateTime eventEndDatetime,
            Integer capacity,
            Integer currentNumberOfPeople,
            String memo,
            LocalDateTime createAt,
            LocalDateTime modifiedAt
    ) {
        return new EventDTO(
                placeId,
                eventName,
                eventStatus,
                eventStartDatetime,
                eventEndDatetime,
                capacity,
                currentNumberOfPeople,
                memo,
                createAt,
                modifiedAt
        );
    }
}
