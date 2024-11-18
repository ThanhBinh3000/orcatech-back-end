package vn.com.gsoft.categories.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.Wards;
import vn.com.gsoft.categories.model.dto.WardsReq;
import vn.com.gsoft.categories.repository.WardsRepository;
import vn.com.gsoft.categories.service.WardsService;

@Log4j2
@Service
public class WardsServiceImpl extends BaseServiceImpl<Wards, WardsReq, Long> implements WardsService {
    private final WardsRepository hdrRepo;

    public WardsServiceImpl(WardsRepository hdrRepo) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
    }
}
