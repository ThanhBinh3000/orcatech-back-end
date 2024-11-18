package vn.com.gsoft.categories.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.entity.Cities;
import vn.com.gsoft.categories.model.dto.CitiesReq;
import vn.com.gsoft.categories.repository.CitiesRepository;
import vn.com.gsoft.categories.service.CitiesService;

@Log4j2
@Service
public class CitiesServiceImpl extends BaseServiceImpl<Cities, CitiesReq, Long> implements CitiesService {
    private final CitiesRepository hdrRepo;

    @Autowired
    public CitiesServiceImpl(CitiesRepository hdrRepo) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
    }
}
