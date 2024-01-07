package umc.spring.validation.validator;

import umc.spring.apiPayload.code.ErrorStatus;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.validation.annotation.CheckStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StatusCheckValidator implements ConstraintValidator<CheckStatus, MissionStatus> {
    @Override
    public void initialize(CheckStatus constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MissionStatus value, ConstraintValidatorContext context) {
        if (!(value.equals(MissionStatus.complete) | value.equals(MissionStatus.progress))) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_STATUS_NOT_FOUND.toString()).addConstraintViolation();

            return false;
        }
        return true;
    }
}
