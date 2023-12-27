package umc.spring.validation.annotation;

import umc.spring.validation.validator.TermsExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TermsExistValidator.class)
@Target(value = {ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistTerms {
    String message() default "해당하는 약관이 없습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
