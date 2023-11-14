package umc.spring.domain;

import lombok.*;
import umc.spring.domain.Embedded.Address;
import umc.spring.domain.enums.Status;
import umc.spring.domain.mapping.AgreeTerms;
import umc.spring.domain.mapping.FoodPreference;
import umc.spring.domain.mapping.MemberMission;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseTimeEntity {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String loginId;
    private String password;
    private String email;
    private String phoneNum;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    private LocalDateTime inactiveDate;
    private int point;
    @Embedded
    private Address address;

    // 멤버가 삭제되어도 review는 남아있다.
    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private List<Review> reviewList = new ArrayList<>();

    //
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();


    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Point> pointList = new ArrayList<>();


    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AgreeTerms> agreeTermsList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodPreference> foodPreferenceList = new ArrayList<>();
}
