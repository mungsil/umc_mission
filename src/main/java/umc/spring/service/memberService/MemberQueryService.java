package umc.spring.service.memberService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;

public interface MemberQueryService {

    boolean isExist(Long id);

    Page<Mission> getMissionList(Long storeId, MissionStatus status, Integer page);


}