package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.embedded.Address;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.mapping.AgreeTerms;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .nickname(member.getNickname())
                .createdAt(member.getCreatedDate())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDTO joinDTO) {
        return Member.builder()
                .loginId(joinDTO.getLoginId())
                .password(joinDTO.getPassword())
                .nickname(joinDTO.getNickname())
                .phoneNum(joinDTO.getPhoneNum())
                //.memberStatus(MemberStatus.active)
                .email(joinDTO.getEmail())
                .address(joinDTO.getAddress()) //임베디드 타입을 클라이언트로부터 어떻게 넘겨받는가? -> address : {city: "", ...}
                .agreeTermsList(new ArrayList<>()) //초기화
                .foodPreferenceList(new ArrayList<>()) //초기화
                .build();
    }


}
