package umc.spring.service.storeService;

import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    public Store addStoreToRegion(StoreRequestDTO.addStoreDTO addStoreDTO);

    public Review addReview(StoreRequestDTO.addReviewDTO request);

    public Mission addMission(StoreRequestDTO.addMissionDTO request);
}
