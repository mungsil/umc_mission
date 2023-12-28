package umc.spring.service.storeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Region;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.*;
import umc.spring.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreCommandServiceImpl implements StoreCommandService {

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;
    @Override
    public Store addStoreToRegion(StoreRequestDTO.addStoreDTO addStoreDTO) {
        Store store = storeRepository.findById(addStoreDTO.getStoreId()).get();
        Region region = regionRepository.findById(addStoreDTO.getRegionId()).get();

        store.setRegion(region);

        return store;
    }

    @Override
    public Review addReview(StoreRequestDTO.addReviewDTO request) {

        //리뷰 엔티티 생성 -> save 잊지말기
        Review review = ReviewConverter.toReview(request);
        //연관관계메서드를 통해 리뷰 추가
        review.setStore(storeRepository.findById(request.getStoreId()).get());
        review.setMember(memberRepository.findById(request.getMemberId()).get());
        reviewRepository.save(review);
        return reviewRepository.save(review);
    }

    @Override
    public Mission addMission(StoreRequestDTO.addMissionDTO request) {
        Mission mission = missionRepository.findById(request.getMissionId()).get();
        mission.setStore(storeRepository.findById(request.getStoreId()).get());

        return mission;
    }
}
