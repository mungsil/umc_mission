package umc.spring.service.storeService;

import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    public Store addStoreToRegion(StoreRequestDTO.addStoreDTO addStoreDTO);
}
