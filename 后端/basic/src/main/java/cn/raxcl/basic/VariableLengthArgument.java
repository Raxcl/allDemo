/**
 * 可变参数测试
 *
 * @author D30100_chenlong
 * @date 2022/6/27 14:47
 */
public class VariableLengthArgument {
    public static void main(String[] args) {
        printVariable("a","b");
        printVariable("a","b", "c", "d");
    }

    private static void printVariable(String a, String b) {
        System.out.println(a+b);
    }
    private static void printVariable(String... args) {
        for(String s: args){
            System.out.println(s);
        }
    }
}
