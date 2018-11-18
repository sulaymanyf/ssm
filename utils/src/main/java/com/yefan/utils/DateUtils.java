package com.yefan.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @Author xiaoqx <Yefansulayman@gmail.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/11/11
 */

public class DateUtils {

    public static String Date2String(Date data, String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String dateString= format.format(data);
        return dateString;
    }
}
