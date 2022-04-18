package raxcl.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 移除n个数使其最大
 *
 * @author D30100_chenlong
 * @date 2022/4/17 22:19
 */
public class RemoveNum {
    public static void main(String[] args) {
        System.out.println(removeNum(new int[]{1,5,9,4,7,3,1},3));
    }

    private static int removeNum(int[] ints,int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int a:ints){
            list.add(a);
        }
        //删除轮次
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < list.size()-1; j++) {
                if (list.get(j)>list.get(j+1)){
                    //删除j
                    list.remove(j);
                    break;
                }
            }
        }
        //输出
        int num = 0;
        for (int a: list){
            num = num*10 +a;
        }
        return num;
    }
}
