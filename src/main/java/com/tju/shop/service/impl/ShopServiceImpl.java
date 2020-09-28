package com.tju.shop.service.impl;

import com.tju.shop.dao.ShopDao;
import com.tju.shop.dto.ShopExecution;
import com.tju.shop.entity.Shop;
import com.tju.shop.enums.ShopStateEnum;
import com.tju.shop.exceptions.ShopOperationException;
import com.tju.shop.service.ShopService;
import com.tju.shop.util.ImageUtil;
import com.tju.shop.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.Date;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    ShopDao shopDao;

    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException {
        //空值判断
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try {
            //给店铺信息赋值
            //0表示未上架在审核
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());

            //添加店铺信息
            int effectedeNum = shopDao.insertShop(shop);
            if (effectedeNum <= 0) {
                throw new ShopOperationException("店铺创建失败");
            } else {
                if (shopImgInputStream != null) {
                    //存储图片
                    try {
                        addShopImg(shop, shopImgInputStream, fileName);
                    } catch (Exception e) {
                        throw new ShopOperationException(("addShopImg error:" + e.getMessage()));
                    }
                    //更新店铺的图片地址
                    effectedeNum = shopDao.updateShop(shop);
                    if (effectedeNum <= 0) {
                        throw new ShopOperationException("更新图片地址失败");
                    }
                }
            }
        } catch (Exception e) {
            throw new ShopOperationException("add Shop error: " + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK);
    }

    private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {
        //获取shop图片目录的相对路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumBnail(shopImgInputStream, fileName, dest);
        shop.setShopImg(shopImgAddr);
    }


}
