package com.brickstar.localcloud.util;

import com.brickstar.localcloud.constants.Constants;

import java.io.File;

/**
 * Created by bricks on 17/10/22.
 */
public class FileUtil {
    public static String location = Constants.filePath;
    public static long getDiskFreeSize(String path){
        File diskPartition = new File(location);
        long freePartionSpace = diskPartition.getFreeSpace();
        System.out.println(freePartionSpace);
        return freePartionSpace;
    }
    public static void main(String[] args){
        getDiskFreeSize(location);
    }

}
