package umc.spring.domain.mapping;

import lombok.*;
import umc.spring.domain.BaseTimeEntity;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MemberStatus;
import umc.spring.domain.enums.MissionStatus;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberMission_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Enumerated(value = EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'progress'")
    private MissionStatus missionStatus; //progress, complete

    //==연관관계 메서드 ==//
    public void setMember(Member member) {
        this.member = member;
        member.getMemberMissionList().add(this);
    }

    public void addMission(Mission mission) {
        this.mission = mission;
        mission.getMemberMissionList().add(this);
    }


}
