package raxcl.stringdemo;

import java.util.Arrays;

/**
 * 寻找比目标字母大的最小字母
 *
 * @author D30100_chenlong
 * @date 2022/4/3 8:48
 */
public class BigChar {
    public static void main(String[] args) {
        BigChar bigChar = new BigChar();
        char[] letters = {'a','b','d'};
        System.out.println(bigChar.nextGreatestLetter(letters,'c'));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        //start 8：38
        //对letters进行排序，进行遍历，判断letters-target的最小值，正数最小
        //如果letters.length-target为负数，则判断负数,,,,如果负数绝对值最大
        Arrays.sort(letters);
        //正数返回
        for(char a : letters){
            if(a-target>0){
                return a;
            }
        }
        //没有正数就返回负数，也就是第一个最大
        return letters[0];
    }
}
