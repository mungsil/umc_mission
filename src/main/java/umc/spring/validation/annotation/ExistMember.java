package umc.spring.validation.annotation;

<<<<<<< HEAD
import umc.spring.validation.validator.CategoriesExistValidator;
import umc.spring.validation.validator.MemberExistValidator;
=======
import umc.spring.validation.validator.MemberExistValidator;
import umc.spring.validation.validator.MissionExistValidator;
>>>>>>> master

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MemberExistValidator.class)
<<<<<<< HEAD
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMember {
    String message() default "존재하지 않는 회원입니다..";
=======
@Target(value = {ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ExistMember {
    String message() default "존재하지 않는 회원입니다.";
>>>>>>> master
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
