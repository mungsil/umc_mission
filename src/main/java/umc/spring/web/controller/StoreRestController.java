package umc.spring.web.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.service.storeService.StoreCommandService;
import umc.spring.service.storeService.StoreQueryService;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService;

    @PostMapping("/region")
    public ApiResponse<StoreResponseDTO.addStoreResultDTO> addStoreToRegion(@RequestBody @Valid StoreRequestDTO.AddStoreDTO addStoreDTO) {
        Store store = storeCommandService.addStoreToRegion(addStoreDTO);
        return ApiResponse.onSuccess(StoreConverter.toStoreResponseDTO(store));
    }

    @PostMapping("/reviews")
    public ApiResponse<StoreResponseDTO.addReviewResultDTO> addReview(@RequestBody @Valid StoreRequestDTO.AddReviewDTO request) {
        Review review = storeCommandService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResult(review));
    }

    @PostMapping("/missions")
    public ApiResponse<StoreResponseDTO.addMissionResultDTO> addMission(
            @RequestBody @Valid StoreRequestDTO.AddMissionDTO request) {
        Mission mission = storeCommandService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.toAddMissionResultDTO(mission));
    }


    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String으로 page 번호를 주세요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH005", description = "access 토큰 형식 오류", content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    })
    @Parameters({
            @Parameter(name="page", description = "조회 페이지 번호, queryString")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(
            @PathVariable @ExistStores Long storeId, @RequestParam(name = "page") Integer page) {

        Page<Review> reviewList = storeQueryService.getReviewList(storeId, page);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }
}
