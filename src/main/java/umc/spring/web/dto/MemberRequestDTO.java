package umc.spring.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.embedded.Address;
import umc.spring.domain.mapping.AgreeTerms;
import umc.spring.domain.mapping.FoodPreference;
import umc.spring.validation.annotation.ExistCategories;
import umc.spring.validation.annotation.ExistTerms;

import javax.validation.constraints.NotNull;
import java.util.List;

public class MemberRequestDTO {

    //? Record header declared for non-record -> Remove element로 해결
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
}
