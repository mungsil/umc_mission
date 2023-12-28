package umc.spring.apiPayload.exception.handler;

import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

public class TermHandler extends GeneralException {
    public TermHandler(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
