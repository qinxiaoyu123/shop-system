package com.tju.shop.service;

import com.tju.shop.dto.ShopExecution;
import com.tju.shop.entity.Shop;
import com.tju.shop.exceptions.ShopOperationException;

import java.io.InputStream;

public interface ShopService {
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
}
