package com.jia.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String toTodayFrom1970(long millisecond){
        return toTodayFrom1970(millisecond,"yyyy-MM-dd");
    }
    public static String toTodayFrom1970(long millisecond, String format){
        //秒
        Date d = new Date();
        d.setTime(millisecond);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(d);
    }
}
