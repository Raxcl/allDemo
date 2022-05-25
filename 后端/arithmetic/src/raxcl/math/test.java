package raxcl.math;


import java.util.Collections;

/**
 * @author D30100_chenlong
 * @date 2022/4/11 10:52
 */
public class test {
    public static void main(String[] args) {
        String a = "_";
        System.out.println(a.equals("_"));
    }

    public static int findTheWinner(int n, int k) {
        if(n<=1){
            return n;
        }
        int ans = (findTheWinner(n-1,k)+k)%n;
        return ans == 0?n : ans;
        // 1 2 3 4 5
        // f(5) ans=f(4)+2%5
        //f(4) ans=f(3)+2%4 2
        //f(3) ans=0
        //f(2) ans=1
        //f(1)=1;
    }


}

