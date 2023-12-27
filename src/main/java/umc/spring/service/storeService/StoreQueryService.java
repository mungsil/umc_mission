package umc.spring.service.storeService;

import umc.spring.domain.Store;

import java.util.Optional;

public interface StoreQueryService {

    public boolean existStore(Long id);
}
