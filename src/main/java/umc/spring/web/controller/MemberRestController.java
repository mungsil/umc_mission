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
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.memberService.MemberQueryService;
import umc.spring.service.memberService.MemberCommandService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    private final MemberQueryService memberQueryService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> joinMember(@RequestBody @Valid MemberRequestDTO.JoinDTO request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }


    @PostMapping("/missions")
    public ApiResponse<MemberResponseDTO.ChallengeMissionResultDTO> challengeMission(@RequestBody @Valid MemberRequestDTO.ChallengeMissionDTO request) {
        MemberMission memberMission = memberCommandService.challengeMission(request);
        return ApiResponse.onSuccess(MemberConverter.toChallengeMissionResultDTO(memberMission));}

    @GetMapping("/{memberId}/missions")
    @Operation(summary = "내가 진행 중인 미션 목록 조회 API", description = "내가 진행 중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String으로 page 번호와 status를 지정해주세요.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH005", description = "access 토큰 형식 오류", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "PAGE4001", description = "PAGE 범위 오류", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MEMBER4001", description = "존재하지 않는 MEMBER", content = @Content(schema = @Schema(implementation = ApiResponse.class)))

    })
    @Parameters({
            @Parameter(name = "page", description = "페이지 번호"),
            @Parameter(name = "status", description = "미션 상태입니다. progress(진행 중) or complete(완료) 두 가지 값을 가져요!")
    })
    public ApiResponse<MemberResponseDTO.MissionListDTO> findMissionListByStatus(
            @PathVariable @ExistMember Long memberId, @RequestParam(name = "status")MissionStatus status, @CheckPage @RequestParam(name = "page") Integer page) {

        Page<Mission> missionList = memberQueryService.getMissionList(memberId, status, page-1);
        return ApiResponse.onSuccess(MemberConverter.MissionListDTO(missionList));
    }
}
