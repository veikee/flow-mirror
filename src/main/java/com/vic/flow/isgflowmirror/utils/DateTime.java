package com.vic.flow.isgflowmirror.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 创建时间：2020/8/16 10:04 下午
 * @Author vic
 * @Description:
 */
public class DateTime {

    public static long stampToDateSecondLong(long timeStamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(timeStamp);
        String result = sdf.format(date);
        return Long.valueOf(result);
    }

    public static long stampToDateMinLong(long timeStamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        Date date = new Date(timeStamp);
        String result = sdf.format(date);
        return Long.valueOf(result);
    }

}
