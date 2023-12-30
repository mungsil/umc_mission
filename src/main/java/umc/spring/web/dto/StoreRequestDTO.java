package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.ExistMission;
import umc.spring.validation.annotation.ExistRegions;
import umc.spring.validation.annotation.ExistStores;

import javax.validation.constraints.NotNull;

public class StoreRequestDTO {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddStoreDTO {
        @ExistStores @NotNull
        Long storeId; //리스트로 받아야하는거아닌감?
        @ExistRegions @NotNull
        Long regionId;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddReviewDTO {
        @ExistStores
        Long storeId;
        //이 친구는 검증안해도되나요?
        Long memberId;
        String content;
        @NotNull
        float score;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddMissionDTO {
        @ExistStores
        Long storeId;
        @ExistMission
        Long missionId;
    }


}
