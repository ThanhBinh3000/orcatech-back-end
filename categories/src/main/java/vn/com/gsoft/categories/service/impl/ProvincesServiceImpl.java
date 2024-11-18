package vn.com.gsoft.categories.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.Provinces;
import vn.com.gsoft.categories.model.dto.ProvincesReq;
import vn.com.gsoft.categories.repository.ProvincesRepository;
import vn.com.gsoft.categories.service.ProvincesService;

@Log4j2
@Service
public class ProvincesServiceImpl extends BaseServiceImpl<Provinces, ProvincesReq, Long> implements ProvincesService {
    private final ProvincesRepository hdrRepo;

    public ProvincesServiceImpl(ProvincesRepository hdrRepo) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
    }
}
