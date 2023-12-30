package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Review;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public boolean isExist(Long id) {
        return memberRepository.existsById(id);
    }

    @Override
    public Page<Review> myReviews(Long id, Pageable pageable) {
        Page<Review> memberReviews = reviewRepository.findAllByMember(memberRepository.findById(id).get(), pageable);
        return memberReviews;
    }
}
