package cn.raxcl.basic.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * @author D30100_chenlong
 * date 2022/7/28 16:49
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayListTest arrayListTest = new ArrayListTest();
        // Arrays.copyOf 测试 （扩容自己）
//        arrayListTest.arraysTest();
        List<String> list = new ArrayList<>();
        // 初始化list
        arrayListTest.init(list);
        // 移除元素测试
        arrayListTest.removeTest(list);
        // 迭代器测试
        arrayListTest.listIteratorTest(list);
        // 元素扩容测试
        arrayListTest.autoExpandTest();
        arrayListTest.handExpandTest();
    }

    private void autoExpandTest() {
        ArrayList<Object> list = new ArrayList<>();
        final int N = 10000000;
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("自动扩容，扩容时间：" + (endTime1 - startTime1));
    }

    private void handExpandTest() {
        ArrayList<Object> list = new ArrayList<>();
        final int N = 10000000;
        long startTime1 = System.currentTimeMillis();
        list.ensureCapacity(N);
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法，扩容时间：" + (endTime1 - startTime1));

    }

    private void removeTest(List<String> list) {
        boolean s = list.remove("4");
        System.out.println(s);
    }

    private void init(List<String> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }
    }

    private void listIteratorTest(List<String> list) {
        ListIterator<String> stringListIterator = list.listIterator(3);
        while (stringListIterator.hasNext()) {
            System.out.println(stringListIterator.next());
        }
    }

    private void arraysTest() {
        // Arrays 测试
        int[] array = new int[]{1,2,3,4};
        int[] ints = Arrays.copyOf(array, 5);
        System.out.println(Arrays.toString(ints));
    }
}
