package raxcl.roma;

import java.util.Scanner;

/**
 * 罗马数字转阿拉伯 优化2
 *  * 执行用时：2 ms
 *  * 内存消耗：51.6 MB
 */
public class Roma2 {
    public static void main(String[] args) {
        Roma2 romaClass = new Roma2();
        Scanner scanner = new Scanner(System.in);
        String roma = scanner.next();
        System.out.println(romaClass.romanToInt(roma));
    }

    public int romavalue(char s){
        switch (s){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }

    public int romanToInt(String s) {
        int sum = 0;
        for(int i = 0; i<s.length(); i++){
            char x = s.charAt(i);
            //转换思路，下一个数比前一个数大则取负
            if(i != s.length()-1 && romavalue(x) < romavalue(s.charAt(i+1))){
                sum += (-romavalue(x)+romavalue(s.charAt(i+1)));
                i++;
                continue;
            }else{
                sum += romavalue(x);
            }
        }
        return sum;
    }

}

