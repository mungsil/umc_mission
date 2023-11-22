package umc.spring.converter;

import umc.spring.web.dto.TempResponse;

public class TempConverter {

    public static TempResponse.TempTestDTO toTempTestDTO() {
        return new TempResponse.TempTestDTO("테스트입니다^^");
    }
    public static TempResponse.TempFlagDTO toTempFlagDTO(Integer flag) {
        return new TempResponse.TempFlagDTO(flag);
    }
}
