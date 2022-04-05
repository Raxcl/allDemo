package raxcl.roma;

import java.util.Scanner;

/**
 * 罗马数字转阿拉伯 优化3 空间优化
 */
public class Roma3 {
    public static void main(String[] args) {
        Roma3 romaClass = new Roma3();
        Scanner scanner = new Scanner(System.in);
        String roma = scanner.next();
        System.out.println(romaClass.romanToInt(roma));
    }

    public int romanToInt(String s) {
        int sum = 0;
        int pre = romavalue(s.charAt(0));
        for(int i = 1; i<s.length(); i++){
            int num = romavalue(s.charAt(i));
            //转换思路，下一个数比前一个数大则取负
            if(pre < num){
                sum -= pre;
            }else{
                sum += pre;
            }
            pre = num;
        }
        sum += pre;
        return sum;
    }

    private int romavalue(char ch){
        switch (ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

}


