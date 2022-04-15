package raxcl.math;

import java.util.HashSet;
import java.util.Set;

/**
 * 运算符号的理解
 *
 * @author D30100_chenlong
 * @date 2022/4/7 14:18
 */
public class Operation {
    public static void main(String[] args) {
        Operation operation = new Operation();
        int i = operation.countNumbersWithUniqueDigits(2);
        System.out.println(i);
    }

    public int countNumbersWithUniqueDigits(int n) {
        //不同个数的公式为（打不出来）
        if(n==0){
            return 1;
        }
        if (n==1){
            return 10;
        }
        int res = 10, cur = 9;
        for (int i=0; i<n-1; i++){
            cur *= 9-i;
            res += cur;
        }
        return res;
    }
}
