package umc.spring.validation.annotation;

import umc.spring.validation.validator.ExistMissionValidator;
import umc.spring.validation.validator.ExistRegionValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistMissionValidator.class)
@Target(value = {ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ExistMission {
    String message() default "해당하는 미션이 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
