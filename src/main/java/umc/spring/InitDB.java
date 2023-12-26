package umc.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.Terms;
import umc.spring.domain.embedded.Address;
import umc.spring.domain.mapping.AgreeTerms;
import umc.spring.domain.mapping.FoodPreference;
import umc.spring.repository.FoodRepository;
import umc.spring.repository.TermsRepository;
import umc.spring.service.MemberService.MemberCommandService;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class InitDB {


    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit();
    }


    @Component
    @RequiredArgsConstructor
    @Transactional
    public static class InitService {

        private final EntityManager em;

        public void dbInit() {
            // 카테고리
            FoodCategory c1 = FoodCategory.builder()
                    .name("한식")
                    .foodPreferenceList(new ArrayList<>())
                    .build();
            FoodCategory c2 = FoodCategory.builder()
                    .name("중식")
                    .foodPreferenceList(new ArrayList<>())
                    .build();
            FoodCategory c3 = FoodCategory.builder()
                    .name("일식")
                    .foodPreferenceList(new ArrayList<>())
                    .build();
            FoodCategory c4 = FoodCategory.builder()
                    .name("양식")
                    .foodPreferenceList(new ArrayList<>())
                    .build();
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.persist(c4);

            // 선호 카테고리
            ArrayList<FoodPreference> preferList = new ArrayList<>();
            FoodPreference foodPreference1 = FoodPreference.builder().foodCategory(c1).build();
            FoodPreference foodPreference2 = FoodPreference.builder().foodCategory(c2).build();
            FoodPreference foodPreference3 = FoodPreference.builder().foodCategory(c3).build();

            foodPreference1.setFoodCategory(c1);
            foodPreference2.setFoodCategory(c2);
            foodPreference3.setFoodCategory(c3);

            em.persist(foodPreference1);
            em.persist(foodPreference2);
            em.persist(foodPreference3);

            preferList.add(foodPreference1);
            preferList.add(foodPreference2);
            preferList.add(foodPreference3);

            // 약관
            Terms t1 = Terms.builder()
                    .title("카메라")
                    .is_required(true)
                    .agreeTermsList(new ArrayList<>())
                    .content("카메라 접근을 허용하시겠습니까?").build();
            Terms t2 = Terms.builder()
                    .title("갤러리")
                    .agreeTermsList(new ArrayList<>())
                    .is_required(true)
                    .content("갤러리 접근을 허용하시겠습니까?").build();
            Terms t3 = Terms.builder()
                    .agreeTermsList(new ArrayList<>())
                    .title("저장소")
                    .is_required(false)
                    .content("저장소 읽기를 허용하시겠습니까?").build();
            em.persist(t1);
            em.persist(t2);
            em.persist(t3);

            // 동의 약관
            ArrayList<AgreeTerms> agreeTermsList = new ArrayList<>();

            AgreeTerms agreeTerms1 = AgreeTerms.builder()
                    .isAgreed(true).build();
            AgreeTerms agreeTerms2 = AgreeTerms.builder()
                    .isAgreed(true).build();
            AgreeTerms agreeTerms3 = AgreeTerms.builder()
                    .isAgreed(false).build();

            agreeTerms1.addTerms(t1);
            agreeTerms2.addTerms(t2);
            agreeTerms3.addTerms(t3);

            em.persist(agreeTerms1);
            em.persist(agreeTerms2);
            em.persist(agreeTerms3);

            agreeTermsList.add(agreeTerms1);
            agreeTermsList.add(agreeTerms2);
            agreeTermsList.add(agreeTerms3);

            // 회원
            Member member = Member.builder()
                    .loginId("mungsil")
                    .password("1111")
                    .phoneNum("010-1111-1111")
                    .nickname("용뭉실")
                    .address(new Address("미", "야", "옹"))
                    .point(0)
                    .agreeTermsList(agreeTermsList)
                    .foodPreferenceList(preferList).build();

            foodPreference1.setMember(member);
            foodPreference2.setMember(member);
            foodPreference3.setMember(member);

            agreeTerms1.setMember(member);
            agreeTerms2.setMember(member);
            agreeTerms3.setMember(member);
            //currentModified 오류 발생(미해결)
            /*preferList.forEach(foodPreference -> foodPreference.setMember(member));
            agreeTermsList.forEach(agreeTerms -> agreeTerms.setMember(member));*/

            em.persist(member);

        }
    }
}
//InitService 클래스를 왜 따로 이너 클래스로 둬서 생성자 주입 받는지 잘 모르겠음.아 postConstruct 해주려고?
//그래도 그냥 클래스를 따로 두지않고 메서드로 빼줬어도 괜찮지 않았을까?