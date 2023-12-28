package umc.spring.apiPayload.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.ErrorStatus;
import umc.spring.apiPayload.validation.annotation.ExistStores;
import umc.spring.service.storeService.StoreQueryService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class ExistStoresValidator implements ConstraintValidator<ExistStores, Long> {
    private final StoreQueryService storeQueryService;
    @Override
    public void initialize(ExistStores constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = storeQueryService.existStore(value);
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_NOT_FOUND.toString()).addConstraintViolation();
        }
        return isValid;
    }
}
