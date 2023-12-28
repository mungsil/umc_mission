package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.memberService.MemberCommandService;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> joinMember(@RequestBody @Valid MemberRequestDTO.JoinDTO request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/missions")
    public ApiResponse<MemberResponseDTO.ChallengeMissionResultDTO> challengeMission(@RequestBody @Valid MemberRequestDTO.ChallengeMissionDTO request) {
        MemberMission memberMission = memberCommandService.challengeMission(request);
        return ApiResponse.onSuccess(MemberConverter.toChallengeMissionResultDTO(memberMission));
    }
}
