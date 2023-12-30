package umc.spring.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.el.ValueExpressionImpl;
import org.springframework.http.HttpStatus;
import umc.spring.apiPayload.code.dto.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // 멤버 관련 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

    // 예시,,,
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),

    // Ror test
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트"),

    // FoodCategory Error
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "FOOD_CATEGORY4001", "음식 카테고리가 없습니다."),


    STORE_NOT_FOUND(HttpStatus.BAD_REQUEST, "STORE4001", "가게가 존재하지 않습니다."),
  
    REGION_NOT_FOUND(HttpStatus.BAD_REQUEST, "REGION4001", "지역이 존재하지 않습니다."),

    // Term Error
    TERM_NOT_FOUND(HttpStatus.NOT_FOUND,"TERM4001","약관이 없습니다."),

    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND,"MISSION4001","미션이 없습니다."),

    MISSION_STATUS_NOT_FOUND(HttpStatus.NOT_FOUND,"MISSION_STATUS4001","미션이 없습니다."),

    PAGE_BAD_REQUEST(HttpStatus.BAD_REQUEST, "PAGE4001", "페이지가 존재하지 않습니다.");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;



    @Override
    public ErrorReasonDTO getErrorReason() {
        return ErrorReasonDTO.builder()
                .code(code)
                .message(message)
                .isSuccess(false).build();
    }

    @Override
    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .httpStatus(httpStatus)
                .code(code)
                .message(message)
                .isSuccess(false).build();
    }
}
/*

? 멤버 관련 에러, 푸드 카테고리 관련 에러 status는 안나눠주는게 좋은걸까

 */