package com.kyukiin.getinline.dto;

import com.kyukiin.getinline.constant.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;


public class APIDataResponseTest {

    @DisplayName("문자열 데이터가 주어지면, 표준 성공 응답을 생성한다.")
    @Test
    void givenStringData_whenCreatingResponse_thanReturnSuccessfulResponse() {
        // Given
        String data = "test data";

        // When
        APIDataResponse response = APIDataResponse.of(data);

        // Then
        assertThat(response)
                .isNotNull() // 바로 밑에 줄 success 검사와 중복임. 빼도 상관없음.
                .hasFieldOrPropertyWithValue("success", true)
                .hasFieldOrPropertyWithValue("errorCode", ErrorCode.OK.getCode())
                .hasFieldOrPropertyWithValue("message", ErrorCode.OK.getMessage())
                .hasFieldOrPropertyWithValue("data", data);
    }


    @DisplayName("데이터가 없을 때, 비어있는 표준 성공 응답을 생성한다.")
    @Test
    void givenNothing_whenCreatingResponse_thanReturnEmptyResponse() {
        // Given

        // When
        APIDataResponse response = APIDataResponse.empty();

        // Then
        assertThat(response)
                .isNotNull() // 바로 밑에 줄 success 검사와 중복임. 빼도 상관없음.
                .hasFieldOrPropertyWithValue("success", true)
                .hasFieldOrPropertyWithValue("errorCode", ErrorCode.OK.getCode())
                .hasFieldOrPropertyWithValue("message", ErrorCode.OK.getMessage())
                .hasFieldOrPropertyWithValue("data", null);
    }

}
