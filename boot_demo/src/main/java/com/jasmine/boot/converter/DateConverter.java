package com.jasmine.boot.converter;

import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 *  日期转换器
 * @author guangchang
 **/
public class DateConverter implements Converter<String, Date> {


    @Override
    public Date convert(String s) {
        return null;
    }
}
