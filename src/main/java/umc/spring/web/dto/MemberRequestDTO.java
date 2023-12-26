package umc.spring.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.embedded.Address;
import umc.spring.domain.mapping.AgreeTerms;
import umc.spring.domain.mapping.FoodPreference;

import java.util.List;

public class MemberRequestDTO {

    //? Record header declared for non-record -> Remove element로 해결
    @Getter
    @NoArgsConstructor
    public static class JoinDTO {
        String loginId;
        String password;
        String nickname;
        String phoneNum;
        String email;
        Address address;
        List<Long> agreeTermsList;
        List<Long> foodPreferenceList;
    }
}
