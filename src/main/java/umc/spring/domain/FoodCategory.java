package umc.spring.domain;

import lombok.*;
import umc.spring.domain.mapping.FoodPreference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodCategory extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foodCategory_id")
    private Long id;
    @Column(nullable = false, length = 30)
    private String name;

    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL)
    private List<FoodPreference> foodPreferenceList = new ArrayList<>();

}
