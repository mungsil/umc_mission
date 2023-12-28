package umc.spring.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.service.storeService.StoreCommandService;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/region")
    public ApiResponse<StoreResponseDTO.addStoreResultDTO> addStoreToRegion(@RequestBody @Valid StoreRequestDTO.addStoreDTO addStoreDTO) {
        Store store = storeCommandService.addStoreToRegion(addStoreDTO);
        return ApiResponse.onSuccess(StoreConverter.toStoreResponseDTO(store));
    }

    @PostMapping("/reviews")
    public ApiResponse<StoreResponseDTO.addReviewResultDTO> addReview(@RequestBody @Valid StoreRequestDTO.addReviewDTO request) {
        Review review = storeCommandService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResult(review));
    }

    @PostMapping("/missions")
    public ApiResponse<StoreResponseDTO.addMissionResultDTO> addMission(@RequestBody @Valid StoreRequestDTO.addMissionDTO request) {
        Mission mission = storeCommandService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionResultDTO(mission));
    }

}
