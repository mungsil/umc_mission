package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Terms;

public interface TermsRepository extends JpaRepository<Terms, Long> {
}
