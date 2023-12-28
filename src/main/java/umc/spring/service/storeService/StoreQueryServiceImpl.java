package umc.spring.service.storeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.repository.StoreRepository;
import umc.spring.service.storeService.StoreQueryService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {
    private final StoreRepository storeRepository;

    public boolean isExist(Long id) {
        return storeRepository.existsById(id);
    }
}
