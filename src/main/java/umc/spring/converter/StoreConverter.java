package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {
    public static StoreResponseDTO.addStoreResultDTO toStoreResponseDTO(Store store) {
        return StoreResponseDTO.addStoreResultDTO.builder()
                .storeName(store.getName())
                .storeId(store.getId())
                .regionName(store.getRegion().getName()).build();
    }

    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review) {

        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .createdAt(review.getCreatedDate().toLocalDate())
                .ownerNickname(review.getMember().getNickname())
                .body(review.getContent())
                .score(review.getScore())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());
        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static StoreResponseDTO.MissionDTO MissionDTO(Mission mission) {
        return StoreResponseDTO.MissionDTO.builder()
                .title(mission.getTitle())
                .content(mission.getContent())
                .reward(mission.getReward())
                .build();
    }

    public static StoreResponseDTO.MissionListDTO MissionListDTO(Page<Mission> missionList) {
        List<StoreResponseDTO.MissionDTO> missionDTOList = missionList.stream()
                .map(StoreConverter::MissionDTO)
                .collect(Collectors.toList());

        return StoreResponseDTO.MissionListDTO.builder()
                .missionDTOList(missionDTOList)
                .build();
    }
}
