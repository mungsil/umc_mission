package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.ErrorStatus;
import umc.spring.domain.Mission;
import umc.spring.service.missionService.MissionQueryService;
import umc.spring.validation.annotation.ExistMission;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ExistMissionValidator implements ConstraintValidator<ExistMission, Long> {
    private final MissionQueryService missionQueryService;
    @Override
    public void initialize(ExistMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isVaild = missionQueryService.isExist(value);
        if (!isVaild) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isVaild;
    }
}
