package umc.spring.domain.mapping;

import lombok.*;
import umc.spring.domain.BaseTimeEntity;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodPreference extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foodPreference_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "foodCategory_id")
    private FoodCategory foodCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    //==연관관계 메서드==//
    public void setFoodCategory(FoodCategory foodCategory) {
        System.out.println("Before setFoodCategory - foodCategory: " + foodCategory);

        this.foodCategory = foodCategory;
        System.out.println("!!" + foodCategory.getFoodPreferenceList());
        System.out.println("!!" + foodCategory.getFoodPreferenceList().toString());
        //System.out.println("!!" + foodCategory.getFoodPreferenceList().n);

        foodCategory.getFoodPreferenceList().add(this);
    }

    public void setMember(Member member) {
        this.member = member;
        member.getFoodPreferenceList().add(this);
    }


}
