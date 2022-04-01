package com.kyukiin.getinline.controller.api;

import com.kyukiin.getinline.constant.ErrorCode;
import com.kyukiin.getinline.constant.PlaceType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(APIPlaceController.class)
class APIPlaceControllerTest {

    private final MockMvc mvc;

    public APIPlaceControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[API] [GET] 장소 리스트 조회")
    @Test
    void givenNothing_whenRequestingPlace_thenReturnPlaceList() throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/api/places"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data[0].placeType").value(PlaceType.COMMON.name()))
                .andExpect(jsonPath("$.data[0].placeName").value("구글코리아(유)"))
                .andExpect(jsonPath("$.data[0].address").value("서울 강남구 테헤란로 152 22층"))
                .andExpect(jsonPath("$.data[0].phoneNumber").value("02-531-9000"))
                .andExpect(jsonPath("$.data[0].capacity").value(358))
                .andExpect(jsonPath("$.data[0].memo").value("구글 코리아 본사"))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.errorCode").value(ErrorCode.OK.getCode()))
                .andExpect(jsonPath("$.message").value(ErrorCode.OK.getMessage()))
                ;

    }

    @DisplayName("[API] [GET] 단일 장소 조회 - 장소 있는 경우")
    @Test
    void givenPlaceAndItsId_whenRequestingPlace_thenReturnsPlaceInStandardResponse() throws Exception {
        // Given
        int placeId = 1;

        // When & Then
        mvc.perform(get("/api/places/" + placeId))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isMap())
                .andExpect(jsonPath("$.data.placeType").value(PlaceType.COMMON.name()))
                .andExpect(jsonPath("$.data.placeName").value("구글코리아(유)"))
                .andExpect(jsonPath("$.data.address").value("서울 강남구 테헤란로 152 22층"))
                .andExpect(jsonPath("$.data.phoneNumber").value("02-531-9000"))
                .andExpect(jsonPath("$.data.capacity").value(358))
                .andExpect(jsonPath("$.data.memo").value("구글 코리아 본사"))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.errorCode").value(ErrorCode.OK.getCode()))
                .andExpect(jsonPath("$.message").value(ErrorCode.OK.getMessage()));
    }


    @DisplayName("[API] [GET] 단일 장소 조회 - 장소 없는 경우")
    @Test
    void givenPlaceId_whenRequestingPlace_thenReturnsPlaceInStandardResponse() throws Exception {
        // Given
        int placeId = 2;

        // When & Then
        mvc.perform(get("/api/places/" + placeId))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isEmpty())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.errorCode").value(ErrorCode.OK.getCode()))
                .andExpect(jsonPath("$.message").value(ErrorCode.OK.getMessage()));
    }
}