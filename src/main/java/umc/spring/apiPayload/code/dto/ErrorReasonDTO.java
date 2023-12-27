package umc.spring.apiPayload.code.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ErrorReasonDTO {
    private final boolean isSuccess;
    private HttpStatus httpStatus;
    private final String code;
    private final String message;

    public boolean getIsSuccess() {
        return isSuccess;
    }
}
