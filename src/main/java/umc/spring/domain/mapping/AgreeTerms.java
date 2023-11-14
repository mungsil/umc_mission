package umc.spring.domain.mapping;

import lombok.*;
import umc.spring.domain.BaseTimeEntity;
import umc.spring.domain.Member;
import umc.spring.domain.Terms;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class AgreeTerms extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agreeTerms_id")
    private Long id;
    private boolean isAgreed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "terms_id")
    private Terms terms;

    // 연관관계 메서드
    public void addTerms(Terms terms) {
        this.terms = terms;
        terms.getAgreeTermsList().add(this);
    }

    public void setMember(Member member) {
        this.member = member;
        member.getAgreeTermsList().add(this);

    }








}
