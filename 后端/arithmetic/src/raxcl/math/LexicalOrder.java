package raxcl.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典序排数
 *
 * @author D30100_chenlong
 * @date 2022/4/18 13:30
 */
public class LexicalOrder {
    public static void main(String[] args) {
        System.out.println(lexicalOrder(1314));
    }
    public static List<Integer> lexicalOrder(int n) {
        //239  判断有几位，
        //1 , 1 1-9,1 1-9 1-9 递归，位数下的值小于n的位数下的值
        //1-n
        List<Integer> ret = new ArrayList<>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            ret.add(number);
            if (number*10<=n){
                number *=10;
            }else{
                while(number%10==9 || number+1>n){
                    number /=10;
                }
                number++;
            }
        }
        return ret;
    }
}
