package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class FoodHandler extends GeneralException {
    public FoodHandler(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
