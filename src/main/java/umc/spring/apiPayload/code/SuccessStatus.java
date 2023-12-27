package umc.spring.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.apiPayload.code.dto.ReasonDTO;

@Getter // ?
@AllArgsConstructor
public enum SuccessStatus implements Basecode{
    _OK(HttpStatus.OK, "COMMON200", "성공입니다.");

    private HttpStatus httpStatus;
    private String code;
    private String message;
    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .code(code)
                .message(message)
                .isSuccess(true).build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return  ReasonDTO.builder()
                .httpStatus(httpStatus)
                .code(code)
                .message(message)
                .isSuccess(true).build();
    }
}
