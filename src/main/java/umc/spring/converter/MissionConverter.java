package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

public class MissionConverter {
    public static StoreResponseDTO.addMissionResultDTO toAddMissionResultDTO(Mission mission) {
        return StoreResponseDTO.addMissionResultDTO.builder()
                .missionTitle(mission.getTitle())
                .missionContent(mission.getContent())
                .storeName(mission.getStore().getName())
                .build();
    }

    public static MemberMission toMemberMission(Mission mission) {
        return MemberMission.builder().build();
    }
}
