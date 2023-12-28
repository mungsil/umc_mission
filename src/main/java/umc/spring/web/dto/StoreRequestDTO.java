package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.ExistRegions;
import umc.spring.validation.annotation.ExistStores;

import javax.validation.constraints.NotNull;

public class StoreRequestDTO {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class addStoreDTO {
        @ExistStores @NotNull
        Long storeId; //리스트로 받아야하는거아닌감?
        @ExistRegions @NotNull
        Long regionId;
    }
}
