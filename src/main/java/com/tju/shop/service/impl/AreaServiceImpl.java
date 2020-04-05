package com.tju.shop.service.impl;

import com.tju.shop.dao.AreaDao;
import com.tju.shop.entity.Area;
import com.tju.shop.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
