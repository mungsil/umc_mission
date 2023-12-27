package umc.spring.domain;

import lombok.*;
import umc.spring.domain.embedded.Address;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    private float score;
    private Address address;

    // 가게가 사라지면 작성된 리뷰도 함께 사라진다.
    @OneToMany(mappedBy = "store",orphanRemoval = true)
    List<Review> reviewList = new ArrayList<>();

    // 가게가 사라지면 미션도 함께 사라진다.
    @OneToMany(mappedBy = "store", orphanRemoval = true)
    List<Mission> missionList = new ArrayList<>();
}
