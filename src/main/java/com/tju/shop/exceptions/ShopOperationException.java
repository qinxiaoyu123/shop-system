package com.tju.shop.exceptions;

public class ShopOperationException extends RuntimeException{
    /**
     *
     * @param msg
     */
    public ShopOperationException(String msg){
        super((msg));
    }
}
