package com.vic.flow.flowmirror.utils;

import java.util.UUID;

/**
 * @version 创建时间：2020/8/16 9:55 下午
 * @Author vic
 * @Description:
 */
public class IDUtil {

    public static long getId(){
        return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }
}
