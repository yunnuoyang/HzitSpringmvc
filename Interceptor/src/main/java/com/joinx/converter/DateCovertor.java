package com.joinx.converter;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCovertor extends PropertyEditorSupport {
    @Override
    public String getAsText() {
        Date date = (Date)getValue();
        if(date==null){
            return "";
        }
        SimpleDateFormat smf=new SimpleDateFormat();
        System.out.println(smf.format(date));
        return smf.format(date);
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println(text+"converter.............");
        if(text==null || text.trim().equals("")){
            return;
        }
        SimpleDateFormat smf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = smf.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        setValue(date);
    }
}
