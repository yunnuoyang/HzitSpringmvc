package com.joinx.interceptor.utils;
import org.junit.Test;

import java.time.*;
import java.util.Date;
public class DateUtils {
    public static void main(String[] args) {
        Date date=new Date();
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime ldt=LocalDateTime.ofInstant(instant,zoneId );
        System.out.println(ldt+"========");
    }
    @Test
    public void t(){
        Date date=new Date();
        Instant instant = date.toInstant();
        //获取系统的默认时区的id
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("=============");
        Date from = Date.from(instant);
        LocalDate ld=LocalDate.now(zoneId);
        ZonedDateTime zdt = ld.atStartOfDay(zoneId);
        Date dates = Date.from(zdt.toInstant());
        System.out.println(ld+"======="+from+"\n???????"+dates);
    }
}
