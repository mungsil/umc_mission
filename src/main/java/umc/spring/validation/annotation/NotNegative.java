package umc.spring.validation.annotation;

import umc.spring.validation.validator.PageNegativeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageNegativeValidator.class)
@Target(value = {ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNegative {
    String message() default "페이지 번호는 0 이상부터 입력 가능합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
