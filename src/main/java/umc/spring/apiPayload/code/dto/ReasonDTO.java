package umc.spring.apiPayload.code.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter // ?
@Builder
public class ReasonDTO {

    private HttpStatus httpStatus;
    private final boolean isSuccess; //왜 final ?
    private final String code;
    private final String message;

    public boolean getIsSuccess() {
        return isSuccess;
    }
}
