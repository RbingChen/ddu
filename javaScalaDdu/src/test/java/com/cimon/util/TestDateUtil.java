package com.cimon.util;
import org.junit.Test;


public class TestDateUtil {

    @Test
    public void testTimestampToDate() throws  Exception{
        System.out.println(DateUtil.timestamp2Date(1613192828000L));
        System.out.println(DateUtil.Date2Timestamp("2021-02-13 13:07:08"));
        System.out.println(DateUtil.addDays(1613192828000L,10));
        System.out.println(DateUtil.addDays("2021-02-13",10));
        System.out.println(DateUtil.getHourFromTs(1613192828000L));
    }
}
