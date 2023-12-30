package umc.spring.validation.validator;

import org.hibernate.annotations.Check;
import umc.spring.apiPayload.code.ErrorStatus;
import umc.spring.validation.annotation.CheckPage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.awt.print.Pageable;

//빈으로 등록 필요?
public class CheckPageValidation implements ConstraintValidator<CheckPage, Pageable> {
    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Pageable value, ConstraintValidatorContext context) {
        int numberOfPages = value.getNumberOfPages();
        if (numberOfPages < 1) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_BAD_REQUEST.toString()).addConstraintViolation();
            return false;
        }

        return true;
    }
}
