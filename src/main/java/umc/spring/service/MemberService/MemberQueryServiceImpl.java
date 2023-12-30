package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.ReviewRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isExist(Long id) {
        return memberRepository.existsById(id);
    }

    @Override
    public Page<Mission> getMissionList(Long memberId, MissionStatus status, Integer page) {
        Member member = memberRepository.findById(memberId).get();

        Page<Mission> MemberMissionList;

        if (status.equals(MissionStatus.complete)) {
            MemberMissionList = memberMissionRepository.findMissionsByMemberAndStatus(member, MissionStatus.complete, PageRequest.of(page, 10));
        }else {
            MemberMissionList = memberMissionRepository.findMissionsByMemberAndStatus(member, MissionStatus.progress, PageRequest.of(page, 10));
        }
        return MemberMissionList;
    }



}