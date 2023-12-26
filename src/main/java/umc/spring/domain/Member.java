package umc.spring.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import umc.spring.domain.embedded.Address;
import umc.spring.domain.enums.MemberStatus;
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
    @Column(nullable = false, length = 30)
    private String nickname;
    @Column(nullable = false, length = 40)
    private String loginId;
    @Column(nullable = false, length = 40)
    private String password;
    //@Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 20)
    private String phoneNum;
    @Enumerated(value = EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus memberStatus; //active, inactive
    private LocalDateTime inactiveDate;
    @ColumnDefault("0")
    private int point;
    @Embedded
    private Address address;

    // 멤버가 삭제되어도 review는 남아있다.
    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    // 어라 point 필드가 있는데 왜 또 pointList를 넣으셨나요?
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Point> pointList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AgreeTerms> agreeTermsList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodPreference> foodPreferenceList = new ArrayList<>();
}
