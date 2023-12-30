package umc.spring.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.code.dto.ErrorReasonDTO;

// RuntimeException을 상속 받았으므로 언체크예외
@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException{

    private BaseErrorCode baseErrorCode;
    public ErrorReasonDTO getErrorReason(){
        return baseErrorCode.getErrorReason();
    }
    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.baseErrorCode.getErrorReasonHttpStatus();
    }

}
