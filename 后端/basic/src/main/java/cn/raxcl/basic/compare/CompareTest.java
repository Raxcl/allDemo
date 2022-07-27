package cn.raxcl.basic.compare;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * 自定义比较器测试
 *
 * @author D30100_chenlong
 * date 2022/7/26 11:19
 */
public class CompareTest {
    public static void main(String[] args) {
        TreeMap<Person, String> treeMap = new TreeMap<>((o1, o2) -> {
            int num = o1.getAge() - o2.getAge();
            return Integer.compare(num, 0);
        });
        treeMap.put(new Person(3), "person1");
        treeMap.put(new Person(18), "person2");
        treeMap.put(new Person(35), "person3");
        treeMap.put(new Person(16), "person4");
        treeMap.entrySet().stream().forEach(personStringEntry -> System.out.println(personStringEntry.getValue()));
    }
}
