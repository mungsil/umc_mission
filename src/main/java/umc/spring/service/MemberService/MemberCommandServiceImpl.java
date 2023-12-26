package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.code.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.apiPayload.exception.handler.FoodHandler;
import umc.spring.apiPayload.exception.handler.TermHandler;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.Terms;
import umc.spring.domain.mapping.AgreeTerms;
import umc.spring.domain.mapping.FoodPreference;
import umc.spring.repository.FoodRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.TermsRepository;
import umc.spring.service.MemberService.MemberCommandService;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final TermsRepository termsRepository;
    private final FoodRepository foodRepository;

    // MemberResponseDTO.JoinResultDTO로 반환과 Member반환의 차이
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDTO request) {

        Member member = MemberConverter.toMember(request);

        // 동의 약관 처리 로직
        // orElseThrow(new TempHandler(BaseErrorCode))가 아닌 orElseThrow(()->new TermHandler(BaseErrorCode))인 이유?
        List<Terms> termsList =
                request.getAgreeTermsList().stream()
                        .map(agreeTerm -> termsRepository.findById(agreeTerm).orElseThrow(() -> new TermHandler(ErrorStatus.TERM_NOT_FOUND)))
                        .collect(Collectors.toList());

        // Term -> agreeTerms
        List<AgreeTerms> agreeTermsList =
                termsList.stream()
                .map(terms -> AgreeTerms.builder()
                        .isAgreed(true)
                        .build())
                .collect(Collectors.toList());

        agreeTermsList.forEach(agreeTerms -> agreeTerms.setMember(member));
        for (int i = 0; i < agreeTermsList.size(); i++) {
            agreeTermsList.get(i).addTerms(termsList.get(i));
        }


        // 선호 음식 카테고리 처리 로직
        List<FoodCategory> foodCategoryList = request.getFoodPreferenceList().stream()
                .map(category -> foodRepository.findById(category)
                        .orElseThrow(() -> new FoodHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)))
                .collect(Collectors.toList());

        // foodCategoryList -> foodPreferenceList
        List<FoodPreference> foodPreferenceList = foodCategoryList.stream().map(foodCategory -> FoodPreference.builder().build()).collect(Collectors.toList());
        foodPreferenceList.forEach(foodPreference -> foodPreference.setMember(member));
        for (int i = 0; i < foodPreferenceList.size(); i++) {
            foodPreferenceList.get(i).setFoodCategory(foodCategoryList.get(i));
        }

        return memberRepository.save(member);
    }
}
