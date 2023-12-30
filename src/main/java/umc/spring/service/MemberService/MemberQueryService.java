package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.enums.MissionStatus;

public interface MemberQueryService {

    boolean isExist(Long id);

    Page<Mission> getMissionList(Long storeId, MissionStatus status, Integer page);


}