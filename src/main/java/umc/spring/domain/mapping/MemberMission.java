package umc.spring.domain.mapping;

import lombok.*;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission {
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
