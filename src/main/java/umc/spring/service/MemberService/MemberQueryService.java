package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import umc.spring.domain.Review;

public interface MemberQueryService {

    boolean isExist(Long id);
    Page<Review> myReviews(Long id, Pageable pageable);

}
