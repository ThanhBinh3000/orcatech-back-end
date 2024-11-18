package vn.com.gsoft.categories.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.categories.constant.RecordStatusContains;
import vn.com.gsoft.categories.entity.Provinces;
import vn.com.gsoft.categories.entity.Regions;
import vn.com.gsoft.categories.model.dto.RegionsReq;
import vn.com.gsoft.categories.repository.CitiesRepository;
import vn.com.gsoft.categories.repository.ProvincesRepository;
import vn.com.gsoft.categories.repository.RegionsRepository;
import vn.com.gsoft.categories.repository.WardsRepository;
import vn.com.gsoft.categories.service.RegionsService;

import java.util.Optional;

@Log4j2
@Service
public class RegionsServiceImpl extends BaseServiceImpl<Regions, RegionsReq, Long> implements RegionsService {
    private final RegionsRepository hdrRepo;

    @Autowired
    public RegionsServiceImpl(RegionsRepository hdrRepo) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
    }

}
