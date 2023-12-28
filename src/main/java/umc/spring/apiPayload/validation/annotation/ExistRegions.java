package umc.spring.apiPayload.validation.annotation;

import umc.spring.apiPayload.validation.validator.ExistRegionValidator;
import umc.spring.apiPayload.validation.validator.ExistStoresValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistRegionValidator.class)
@Target(value = {ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ExistRegions {
    String message() default "해당하는 지역이 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
