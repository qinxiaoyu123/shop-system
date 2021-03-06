package com.tju.shop.dao;

import com.tju.shop.BaseTest;
import com.tju.shop.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
//this.getClass().getResource("/").getPath();
import static org.junit.Assert.assertEquals;

public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea(){
        List<Area> areaList = areaDao.queryArea();
        assertEquals(3, areaList.size());
    }
}
