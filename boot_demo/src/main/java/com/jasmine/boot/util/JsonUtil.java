package com.jasmine.boot.util;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author guangchang
 */
public class JsonUtil {

    public enum LetterType {
        UPPERCASE(1),LOWERCASE(2);
        private final int type;

        private LetterType(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }
    }

    /**
     * json字符串转换javabean
     * @param json json字符串
     * @param bean 对象.class
     * @return T
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     * */
    @SuppressWarnings("unchecked")
    public static <T> T jsonStrToJava(String json,Class<?> bean) throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        if(json.indexOf("/Date(")>0) {
            json = JsonUtil.jsonDateToJavaDate(json);
        }
        return (T) objectMapper.readValue(json, bean);
    }

    /**
     * json字符串转换javabean
     * @param json json字符串
     * @param bean 对象.class
     * @param toggleCase 是否转换key的大小写
     * @param letterType 转换枚举类 UPPERCASE-大写、LOWERCASE-小写
     * @return T
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     * */
    @SuppressWarnings("unchecked")
    public static <T> T jsonStrToJava(String json,Class<?> bean,boolean toggleCase,LetterType letterType) throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        if(toggleCase) {
            json =JsonUtil.convertLetter(json,letterType);
        }
        if(json.indexOf("/Date(")>0) {
            json = JsonUtil.jsonDateToJavaDate(json);
        }
        return (T) objectMapper.readValue(json, bean);
    }

    /**
     * json字符串转换key的大小写
     * @param json json字符串
     * @param letterType 转换枚举类 UPPERCASE-大写、LOWERCASE-小写
     * @return json字符串
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     * */
    public static String convertLetter(String json,LetterType letterType) throws JsonParseException, JsonMappingException, IOException {
        Map<String,String> map = JsonUtil.jsonStrToJava(json, Map.class);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if(letterType.getType()==1) {
                map.put(entry.getKey().toUpperCase(), entry.getValue());
            }else {
                map.put(entry.getKey().toLowerCase(), entry.getValue());
            }
            map.remove(entry.getKey());
        }
        return JsonUtil.javaToJson(map);
    }

    /**
     *  javabean转换json字符串
     * @return
     * @throws JsonProcessingException
     * */
    public static String javaToJson(Object bean) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(bean);
        return json;
    }

    /**
     *  json字符串中存在Date(1558427619277+0800)类似的时间格式进行转换
     *  @param    json json字符串
     * @return     json json字符串
     * @throws JsonProcessingException
     * */
    public static String jsonDateToJavaDate(String json) throws JsonParseException, JsonMappingException, IOException {
        Map<String,String> map = JsonUtil.jsonStrToJava(json, Map.class);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if(entry.getValue().indexOf("/Date(")>0) {
                String dateJSON = entry.getValue().replace("/Date(","").replace(")/","");
                Long dateLong = Long.valueOf(dateJSON.substring(0, dateJSON.length()-5));
                Date date = new Date(dateLong);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                map.put(entry.getKey(), format.format(date));
            }
        }
        return JsonUtil.javaToJson(map);
    }


}