package cn.raxcl.basic.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ModelTest {
    public static void main(String[] args) {
        ModelDemo modelDemo = new ModelDemo();
        ModelDemo modelDemo2 = new ModelDemo();
        modelDemo2.setStr("111");
        modelDemo2.setName("222");

        modelDemo.setStr(JSONObject.toJSONString(modelDemo2));
        modelDemo.setName("kkk");
        String s1 = JSONObject.toJSONString(modelDemo);
        System.out.println(s1);


        modelDemo.setName("小草神");
        modelDemo.setStr("SSS");
        JSONObject jsonObject = (JSONObject) JSON.toJSON(modelDemo);
        System.out.println(jsonObject);
        JSONObject newJsonObject = new JSONObject();
        newJsonObject.put("name", "qqq");
        newJsonObject.put("str", jsonObject);
        String s = JSON.toJSONString(jsonObject);

        newJsonObject.put("str1", JSON.toJSONString(jsonObject));
//        String s = JSON.toJSONString(jsonObject);
        System.out.println(newJsonObject);
    }
}
