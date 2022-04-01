package com.kyukiin.getinline.controller.api;

import com.kyukiin.getinline.constant.PlaceType;
import com.kyukiin.getinline.dto.APIDataResponse;
import com.kyukiin.getinline.dto.PlaceDTO;
import com.kyukiin.getinline.dto.PlaceResponse;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/api")
@RestController
public class APIPlaceController {

    @GetMapping("/places")
    public APIDataResponse<List<PlaceResponse>> getPlaces() {
        return APIDataResponse.of(List.of(PlaceResponse.of(
                PlaceType.COMMON,
                "구글코리아(유)",
                "서울 강남구 테헤란로 152 22층",
                "02-531-9000",
                358,
                "구글 코리아 본사"
        )));
    }

    @PostMapping("/places")
    public Boolean createPlace() { return true; }

    @GetMapping("/places/{placeId}")
    public APIDataResponse<PlaceDTO> getPlace(@PathVariable Integer placeId) {
        if(placeId.equals(2)) {
            return APIDataResponse.of(null);
        }

        return APIDataResponse.of(PlaceDTO.of(
                PlaceType.COMMON,
                "구글코리아(유)",
                "서울 강남구 테헤란로 152 22층",
                "02-531-9000",
                358,
                "구글 코리아 본사"
        ));
    }

    @PutMapping("/places/{placeId}")
    public Boolean modifyPlace(@PathVariable Integer placeId) { return true; }

    @DeleteMapping("/places/{placeId}")
    public Boolean removePlace(@PathVariable Integer placeId) { return true; }

}