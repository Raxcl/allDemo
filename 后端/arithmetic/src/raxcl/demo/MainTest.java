package raxcl.demo;

import com.sun.deploy.util.StringUtils;

import java.util.Stack;

/**
 * @author D30100_chenlong
 * @date 2023/3/13 16:03
 */

public class MainTest {
    /**
     * 输入一行英文句子，里面包含英文字母，空格以及,.? 三种标点符号，请将句子内每个单词进行倒序，并输出倒序后的语句
     * ohW era? uoy ? I ma xelA. I am
     * Who are you ? I am Alex. char ?
     * era?  are?
     * era ? are ?
     * xelA  .
     * 思路：
     * String splipt（） String[]
     * for
     * @param args
     */
    public static void main(String[] args) {
        soutDemo1("ohW era uoy ? I ma xelA.");
    }

    private static void soutDemo(String temStr) {
        String[] strArray = temStr.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            int n = strArray[i].length() - 1;
            char c = strArray[i].charAt(n);
            if (strArray[i].length() > 1 && (c < 'A' || c > 'Z') && (c < 'a' || c > 'z')) {
                n -= 1;
            }
            for (int j=n; j>=0; j--) {
                System.out.print(strArray[i].charAt(j));
            }
            if (n != strArray[i].length() - 1) {
                System.out.print(strArray[i].charAt(n + 1));
            }
            System.out.print(" ");
        }
    }

    // 用栈的方式处理，遇到标点符号或者空格就出栈
    private static void soutDemo1(String temStr) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < temStr.length(); i++) {
            if (temStr.charAt(i) == ' ' || temStr.charAt(i) == '.' || temStr.charAt(i) == ',' || temStr.charAt(i) == '?') {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop());
                }
                System.out.print(temStr.charAt(i));
            } else {
                stack.push(temStr.charAt(i));
            }
        }
    }
}
