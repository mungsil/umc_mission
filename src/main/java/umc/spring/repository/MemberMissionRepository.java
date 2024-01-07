package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission,Long> {
    @Query("SELECT m.mission FROM MemberMission m " +
            "WHERE m.member = :member " +
            "AND m.missionStatus = :status " +
            "ORDER BY m.createdDate DESC")
    Page<Mission> findMissionsByMemberAndStatus(@Param("member") Member member,
                                                @Param("status") MissionStatus status,
                                                Pageable pageable);

}
