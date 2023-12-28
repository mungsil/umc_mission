package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.service.missionService.MissionQueryService;
import umc.spring.validation.annotation.NotChallenge;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class NotChallengeValidator {
    // ConstraintValidator를 이용해서는 memberId와 missionId를 이용하여 검증이 어려운 것으로 판단, 일단 만들어놓기만 했음
    // 검증은 서비스단에서 구현
}
