package com.tju.shop.service;

import com.tju.shop.dto.ShopExecution;
import com.tju.shop.entity.Shop;

import java.io.File;

public interface ShopService {
    ShopExecution addShop(Shop shop, File shopImg);
}
