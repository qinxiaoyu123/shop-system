package com.tju.shop.util;

public class PathUtil {
    private static String seperator = System.getProperty("file.separator");
    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase().startsWith("win")){
            basePath = "F:/github_workspace/";
        }
        else{
            basePath = "/home/xiaoyuqin/image/";
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }
    public static String getShopImagePath(long shopId){
        String imagePath = "";
        return imagePath.replace("/",seperator);
    }

}
