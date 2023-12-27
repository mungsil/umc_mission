package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.ErrorStatus;
import umc.spring.repository.FoodRepository;
import umc.spring.repository.TermsRepository;
import umc.spring.validation.annotation.ExistTerms;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TermsExistValidator implements ConstraintValidator<ExistTerms, List<Long>> {

    private final TermsRepository termsRepository;
    @Override
    public void initialize(ExistTerms constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> value, ConstraintValidatorContext context) {

        boolean isValid = value.stream().allMatch(term -> termsRepository.existsById(term));
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.TERM_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
