package umc.spring.service.regionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.repository.RegionRepository;
import umc.spring.service.regionService.RegionQueryService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionQueryServiceImpl implements RegionQueryService {
    private final RegionRepository regionRepository;
    @Override
    public boolean existRegion(Long id) {
        return regionRepository.existsById(id);
    }
}
