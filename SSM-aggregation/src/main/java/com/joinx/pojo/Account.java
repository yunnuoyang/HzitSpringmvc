package com.joinx.pojo;

import org.junit.Test;
import sun.dc.pr.PRError;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;

public class Account {
    private Integer accID;
    private String accName;
    private String passWord;
    private Float balance;
    private Integer state;
    private LocalDateTime accDate;
    private String accDateDto;
    @Override
    public String toString() {
        return "Account{" +
                "accID=" + accID +
                ", accName='" + accName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", balance=" + balance +
                ", state=" + state +
                ", accDate=" + accDate +
                '}';
    }

    public Integer getAccID() {
        return accID;
    }

    public void setAccID(Integer accID) {
        this.accID = accID;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public LocalDateTime getAccDate() {
        return accDate;
    }

    public void setAccDate(LocalDateTime accDate) {
        this.accDate = accDate;
    }

    public void setAccDateDto(String accDateDto) {
        SimpleDateFormat smf=new SimpleDateFormat("yyyy-MM-dd");
        Date parse=null;
        try {
            parse = smf.parse(accDateDto);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Instant instant = parse.toInstant();
        ZoneId zoneId=ZoneId.systemDefault();
        LocalDateTime localDateTime=LocalDateTime.ofInstant(instant,zoneId);
        setAccDate(localDateTime);
    }
    @Test
    public void test1(){
        String str="2019-8-16";
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-M-dd");
        LocalDate parse = LocalDate.parse(str, formatter);
        String string = parse.toString();
        System.out.println(parse+"===="+string);
    }
    @Test
    public void test2(){
        String str="2019-08-16 12:31:26";
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(str, formatter);
        String string = parse.toString();
        System.out.println(parse+"===="+string);
    }
    @Test
    public void test3(){
        String str="12:31:26";
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime parse = LocalTime.parse(str, formatter);
        String string = parse.toString();
        System.out.println(parse+"===="+string);
    }
    @Test
    public void test4(){
        //需要转换为LocalDateTime格式的Date
        Date date=new Date();
        //java8提供的解决方式
        Instant instant = date.toInstant();
        //获取系统的默认时区
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime =null;
        localDateTime =  LocalDateTime.ofInstant(instant, zoneId);
        System.out.println(localDateTime);


    }
}
