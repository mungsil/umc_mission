package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class MemberResponseDTO {
    @Getter
    @Builder
    @NoArgsConstructor //왜?
    @AllArgsConstructor //왜?
    public static class JoinResultDTO {
        Long memberId;
        String nickname;
        LocalDateTime createdAt;
    }
}
