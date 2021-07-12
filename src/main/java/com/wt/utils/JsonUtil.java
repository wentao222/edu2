package com.wt.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 用于把java对象装换成json对象的工具类
 */
public class JsonUtil {
    private static ObjectMapper m = new ObjectMapper();

    // 传入一个对象把它转换成json格式的对象
    public static String toJson(Object obj) {
        String json = "";
        try {
            json = m.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
