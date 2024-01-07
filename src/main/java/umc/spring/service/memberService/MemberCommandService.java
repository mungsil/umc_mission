package umc.spring.service.memberService;

import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDTO.JoinDTO request);

    public MemberMission challengeMission(MemberRequestDTO.ChallengeMissionDTO request);

}
