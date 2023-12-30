package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.embedded.Address;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.mapping.AgreeTerms;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static MemberResponseDTO.MissionDTO MissionDTO(Mission mission) {
        return MemberResponseDTO.MissionDTO.builder()
                .title(mission.getTitle())
                .content(mission.getContent())
                .reward(mission.getReward())
                .build();
    }

    public static MemberResponseDTO.MissionListDTO MissionListDTO(Page<Mission> missionList) {
        List<MemberResponseDTO.MissionDTO> missionDTOList = missionList.stream()
                .map(MemberConverter::MissionDTO)
                .collect(Collectors.toList());

        return MemberResponseDTO.MissionListDTO.builder()
                .missionDTOList(missionDTOList)
                .build();
    }


}
