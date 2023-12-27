package umc.spring.converter;

import umc.spring.domain.Store;
import umc.spring.web.dto.StoreResponseDTO;

public class StoreConverter {
    public static StoreResponseDTO.addStoreResultDTO toStoreResponseDTO(Store store) {
        return StoreResponseDTO.addStoreResultDTO.builder()
                .storeName(store.getName())
                .storeId(store.getId())
                .regionName(store.getRegion().getName()).build();
    }
}
