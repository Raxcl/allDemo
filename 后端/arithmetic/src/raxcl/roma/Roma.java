package raxcl.roma;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 罗马数字转阿拉伯
 * 执行用时：4 ms
 * 内存消耗：41.6 MB
 */
public class Roma {
    public static void main(String[] args) {
        Roma romaClass = new Roma();
        Scanner scanner = new Scanner(System.in);
        String roma = scanner.next();
        System.out.println(romaClass.romanToInt(roma));
    }

    public int romanToInt(String s) {
        //时间：18：18
        //题目：给罗马判断阿拉伯，
        //I:1
        //V:5
        //X:10
        //L:50
        //C:100
        //D:500
        //M:1000
        //1. 对罗马和阿拉伯做映射
        //2. 判断所在位数，转换成阿拉伯（相加）
        //3. 对I,X,C以及下一位数
        //IV:4   IX:9
        //XL:40  XC:90
        //CD:400 CM:900
        //1. 主要逻辑：获取输入字符串，
        //2. 从左到右for循环，判断是否符合上述条件，符合就越位判断
        //用sum存放最终结果，i做下标


        //1. 对罗马和阿拉伯做映射(键值对)
        Map<Character,Integer> map = new HashMap(8);
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        //2. 从左到右for循环
        int sum = 0;
        for(int i = 0; i<s.length(); i++){
            char x = s.charAt(i);
            //3. 判断是否符合上述条件，符合就越位判断
            //3.1 先判断是否是最后一位
            if(!(i<s.length()-1)){
                //是最后一位，直接返回
                sum += map.get(x);
                return sum;
            }
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
            //4. 不是特殊条件正常判断
            sum += map.get(x);
        }
        return sum;
    }
}
