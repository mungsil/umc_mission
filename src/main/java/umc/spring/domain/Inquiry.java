package umc.spring.domain;

import lombok.*;
import umc.spring.domain.enums.Status;

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
    private String content;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    // 이미지 테이블 ?
    private String image_path;

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id")
    private Answer answer;

}
