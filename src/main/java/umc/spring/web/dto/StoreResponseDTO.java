package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.ExistRegions;
import umc.spring.validation.annotation.ExistStores;

import javax.validation.constraints.NotNull;

public class StoreResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addStoreResultDTO {
        Long storeId;
        String storeName;
        String regionName;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class addReviewResultDTO {
       String storeName;
       float score;
       String content;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class addMissionResultDTO {
        String storeName;
        String missionTitle;
        String missionContent;
    }
}
