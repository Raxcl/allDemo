package raxcl.roma;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 罗马数字转阿拉伯 优化1
 * 执行用时：2 ms
 * 内存消耗：41.6 MB
 */
public class Roma1 {
    public static void main(String[] args) {
        Roma1 romaClass = new Roma1();
        Scanner scanner = new Scanner(System.in);
        String roma = scanner.next();
        System.out.println(romaClass.romanToInt(roma));
    }

    public int romanToInt(String s) {
        //2. 从左到右for循环
        int sum = 0;
        for(int i = 0; i<s.length(); i++){
            char x = s.charAt(i);
            //3. 判断是否符合上述条件，符合就越位判断
            //3.1 先判断是否是最后一位
            if(i != s.length()-1){
                //3.2 判断特殊条件
                switch (x){
                    case 'C':
                        if(s.charAt(i+1)=='M'){
                            sum += 900;
                            i++;
                            continue;
                        }
                        if(s.charAt(i+1)=='D'){
                            sum += 400;
                            i++;
                            continue;
                        }
                        break;
                    case 'X':
                        if(s.charAt(i+1)=='C'){
                            sum += 90;
                            i++;
                            continue;
                        }
                        if(s.charAt(i+1)=='L'){
                            sum += 40;
                            i++;
                            continue;
                        }
                        break;
                    case 'I':
                        if(s.charAt(i+1)=='X'){
                            sum += 9;
                            i++;
                            continue;
                        }
                        if(s.charAt(i+1)=='V'){
                            sum += 4;
                            i++;
                            continue;
                        }
                        break;
                }
            }

            //4. 不是特殊条件正常判断
            switch (x){
                case 'I': sum += 1;break;
                case 'V': sum += 5;break;
                case 'X': sum += 10;break;
                case 'L': sum += 50;break;
                case 'C': sum += 100;break;
                case 'D': sum += 500;break;
                case 'M': sum += 1000;break;
            }
        }
        return sum;
    }

}
