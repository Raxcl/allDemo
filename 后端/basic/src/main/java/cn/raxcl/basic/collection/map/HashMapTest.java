package cn.raxcl.basic.collection.map;

import java.util.*;

/**
 * 迭代map的几种方式
 * 四大类，七小类：
 *  1. 迭代器（Iterator）方式遍历；
 *      a. 使用迭代器（Iterator）EntrySet 的方式进行遍历；
 *      b. 使用迭代器（Iterator）KeySet 的方式进行遍历；
 *  2. For Each 方式遍历；
 *      c. 使用 For Each EntrySet 的方式进行遍历；
 *      d. 使用 For Each KeySet 的方式进行遍历；
 *  3. Lambda 表达式遍历（JDK 1.8+）;
 *      e. 使用 Lambda 表达式的方式进行遍历；
 *  4. Streams API 遍历（JDK 1.8+）。
 *      f. 使用 Streams API 单线程的方式进行遍历；
 *      g. 使用 Streams API 多线程的方式进行遍历。
 * @author D30100_chenlong
 * @date 2022/5/17 10:39
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMapTest hashMapTest = new HashMapTest();
        Map<Integer, String> map = new HashMap<>();
        // map初始化
        hashMapTest.init(map);
        // 方式一. 迭代器（Iterator）方式遍历
        //      a. 使用迭代器（Iterator）EntrySet 的方式进行遍历；
        hashMapTest.iteratorEntrySet(map);
        //      b. 使用迭代器（Iterator）KeySet 的方式进行遍历；
        hashMapTest.iteratorKeySet(map);
        // 方式二. For Each 方式遍历
        //      c. 使用 For Each EntrySet 的方式进行遍历；
        hashMapTest.forEachEntrySet(map);
        //      d. 使用 For Each KeySet 的方式进行遍历；
        hashMapTest.forEachKeySet(map);
        // 方式三. Lambda 表达式遍历（JDK 1.8+）;
        //      e. 使用 Lambda 表达式的方式进行遍历；
        hashMapTest.lambda(map);
        // 方式四. Streams API 遍历（JDK 1.8+）。
        //      f. 使用 Streams API 单线程的方式进行遍历；
        hashMapTest.streamSingle(map);
        //      g. 使用 Streams API 多线程的方式进行遍历。
        hashMapTest.streamMultiple(map);
    }

    private void streamMultiple(Map<Integer, String> map) {
        System.out.println("streamMultiple:");
        map.entrySet().parallelStream().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }

    private void streamSingle(Map<Integer, String> map) {
        System.out.println("streamSingle:");
        map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }

    private void lambda(Map<Integer, String> map) {
        System.out.println("lambda:");
        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    private void forEachKeySet(Map<Integer, String> map) {
        System.out.println("forEachKeySet:");
        for (Integer key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
        }
    }

    private void forEachEntrySet(Map<Integer, String> map) {
        System.out.println("forEachEntrySet:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    private void iteratorKeySet(Map<Integer, String> map) {
        Iterator<Integer> iterator = map.keySet().iterator();
        System.out.println("iteratorKeySet:");
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println(key + " : " + map.get(key));
        }
    }

    private void iteratorEntrySet(Map<Integer, String> map) {
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        System.out.println("iteratorEntrySet:");
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }


    private void init(Map<Integer, String> map) {
        map.put(1, "Java");
        map.put(2, "小说");
        map.put(3, "魔法");
        map.put(4, "超能力");
        map.put(5, "修仙");
    }
}
