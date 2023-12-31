package umc.spring.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.embedded.Address;
import umc.spring.validation.annotation.ExistCategories;
import umc.spring.validation.annotation.ExistMission;
import umc.spring.validation.annotation.ExistTerms;
import javax.validation.constraints.NotNull;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    @NoArgsConstructor
    public static class JoinDTO {
        @NotNull
        String loginId;
        @NotNull
        String password;
        @NotNull
        String nickname;
        @NotNull
        String phoneNum;
        String email;
        @NotNull
        Address address;
        @ExistTerms
        List<Long> agreeTermsList;
        @ExistCategories
        List<Long> foodPreferenceList;
    }

    @Getter
    @NoArgsConstructor
    public static class ChallengeMissionDTO {
        @NotNull
        Long memberId;
        @ExistMission
        Long missionId;
    }

}
