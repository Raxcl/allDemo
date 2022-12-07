package cn.raxcl.basic.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author D30100_chenlong
 * @date 2022/6/27 21:53
 */
public class Test {
    private static byte a;
    public static void main(String[] args)  {
        Runtime runtime = Runtime.getRuntime();
        //获取当前电脑的CPU数量/核心数
        int cpuNums = runtime.availableProcessors();
        System.out.println("当前有CPU个数 "+cpuNums);//当前有CPU个数 8

    }

    private void a() {
        Map<String, StringBuilder> fieldValueSqlMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder("aaa");
        fieldValueSqlMap.put("a", stringBuilder);
        Test test = new Test();
        test.b(fieldValueSqlMap);
        System.out.println(fieldValueSqlMap.get("a"));
    }

    private void b(Map<String, StringBuilder> str) {
    }

}