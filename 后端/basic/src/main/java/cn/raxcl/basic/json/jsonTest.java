package cn.raxcl.basic.json;

import com.alibaba.fastjson.JSONObject;

public class jsonTest {
    public static void main(String[] args) {
        String str = "{\"str\":\"SSS\",\"name\":\"小草神\"}";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("str", str);
        System.out.println(jsonObject);
    }
}
