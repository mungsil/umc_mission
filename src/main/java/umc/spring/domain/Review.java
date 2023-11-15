package umc.spring.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="store_id")
    private Store store;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ReviewImage> reviewImageList = new ArrayList<>();

    //== 연관관계 (편의) 메서드 ==//
    public void setMember(Member member) {
        this.member = member;
        member.getReviewList().add(this);
    }

    public void setStore(Store store) {
        this.store = store;
        store.getReviewList().add(this);
    }

    public void addReviewImage(ReviewImage reviewImage) {
        this.getReviewImageList().add(reviewImage);
        //setter vs builder
        reviewImage.setReview(this);
        //ReviewImage.builder()
    }

}
