package umc.spring.domain;

import lombok.*;
import umc.spring.domain.mapping.AgreeTerms;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Terms extends BaseTimeEntity {
    @Id
    @Column(name = "terms_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private boolean is_required;

    @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
    private List<AgreeTerms> agreeTermsList = new ArrayList<>();
}
