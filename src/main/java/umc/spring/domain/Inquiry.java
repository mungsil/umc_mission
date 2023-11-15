package umc.spring.domain;

import lombok.*;
import umc.spring.domain.enums.InquiryStatus;
import umc.spring.domain.enums.MemberStatus;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Inquiry extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inquiry_id")
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Enumerated(value = EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'PRIVATE'")
    private InquiryStatus status; //public, private
    @Column(columnDefinition = "TEXT")
    private String image_path;

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id")
    private Answer answer;

}
