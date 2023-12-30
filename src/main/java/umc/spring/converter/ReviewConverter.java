package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

//StoreConverter로 옮기기
public class ReviewConverter {
    public static Review toReview(StoreRequestDTO.AddReviewDTO request) {
        return Review.builder()
                .content(request.getContent())
                .score(request.getScore())
                .build();
    }

    public static StoreResponseDTO.addReviewResultDTO toAddReviewResult(Review review) {
        return StoreResponseDTO.addReviewResultDTO.builder()
                .storeName(review.getStore().getName())
                .content(review.getContent())
                .score(review.getScore()).build();
    }

}
