package cn.raxcl.basic.test;

import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author D30100_chenlong
 * @date 2022/6/27 21:53
 */
public class Test {
    private static byte a;
    public static void main(String[] args)  {
            String str = "繁hsdf噶";
        System.out.println(str.length());
//        int[] arr = {1};
//        Test test = new Test();
//        test.change(arr);
//        System.out.println(Arrays.toString(arr));
        Model model = null;
        String name = Objects.requireNonNull(model).getName();
        System.out.println(name);

    }

    private void change(int[] arr) {
//        arr[0] = 2;
        arr[0]++;
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