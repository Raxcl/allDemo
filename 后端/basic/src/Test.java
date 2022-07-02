import java.lang.reflect.Field;
import java.util.HashSet;

/**
 * @author D30100_chenlong
 * @date 2022/6/27 21:53
 */
public class Test {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        final String str1 = "str";
        final String str2 = "ing";
// 下面两个表达式其实是等价的
        String c = "str" + "ing";// 常量池中的对象
        String d = str1 + str2; // 常量池中的对象
        System.out.println(c == d);// true


    }
}
