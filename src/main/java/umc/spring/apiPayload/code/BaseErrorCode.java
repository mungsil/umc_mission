package umc.spring.apiPayload.code;

import umc.spring.apiPayload.code.dto.ErrorReasonDTO;

public interface BaseErrorCode {
    public ErrorReasonDTO getErrorReason();
    public ErrorReasonDTO getErrorReasonHttpStatus();
}
