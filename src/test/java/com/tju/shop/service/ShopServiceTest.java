package com.tju.shop.service;

import com.tju.shop.BaseTest;
import com.tju.shop.dto.ShopExecution;
import com.tju.shop.entity.Area;
import com.tju.shop.entity.PersonInfo;
import com.tju.shop.entity.Shop;
import com.tju.shop.entity.ShopCategory;
import com.tju.shop.enums.ShopStateEnum;
import com.tju.shop.exceptions.ShopOperationException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService  shopService;

    @Test
    public void testAddShop() throws ShopOperationException, FileNotFoundException {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺4");
        shop.setShopDesc("test3");
        shop.setShopAddr("test3");
        shop.setPhone("test3");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");
        File shopImg = new File("F:\\github_workspace\\xiaohuangren.jpg");
        InputStream is = new FileInputStream(shopImg);
        ShopExecution se = shopService.addShop(shop, is,shopImg.getName());
        assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
    }
}
