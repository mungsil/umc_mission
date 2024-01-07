package umc.spring.validation.annotation;

<<<<<<< HEAD
import umc.spring.validation.validator.CheckPageValidation;
import umc.spring.validation.validator.PageNegativeValidator;
=======
import umc.spring.validation.validator.PageCheckValidation;
>>>>>>> master

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
<<<<<<< HEAD
@Constraint(validatedBy = CheckPageValidation.class)
=======
@Constraint(validatedBy = PageCheckValidation.class)
>>>>>>> master
@Target({ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "페이지 번호는 1 이상부터 입력 가능합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
<<<<<<< HEAD
}
=======
}
>>>>>>> master
