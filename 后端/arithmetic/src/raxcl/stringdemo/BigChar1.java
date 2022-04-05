package raxcl.stringdemo;

import java.util.Arrays;

/**
 * 寻找比目标字母大的最小字母 官方测试
 *
 * @author D30100_chenlong
 * @date 2022/4/3 8:48
 */
public class BigChar1 {
    public static void main(String[] args) {
        BigChar1 bigChar = new BigChar1();
        char[] letters = {'a','b','c','d','f','k','y','z'};
        System.out.println(bigChar.nextGreatestLetter(letters,'c'));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        if (target >= letters[length - 1]) {
            return letters[0];
        }
        int low = 0, high = length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (letters[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return letters[low];
    }
}
