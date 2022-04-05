package raxcl.stringdemo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 二倍数对数组
 *
 * @author D30100_chenlong
 * @date 2022/4/2 16:35
 */
public class Duishuzu {
    public static void main(String[] args) {
        Duishuzu duishuzu = new Duishuzu();
        int[] arr = {4,-2,2,-4};
        System.out.println(duishuzu.canReorderDoubled(arr));;
    }

    public boolean canReorderDoubled(int[] arr) {
        //start 16:14
        // i >=0 && i < arr.length/2
        //arr[2*i +1] = 2 * arr[2*i]
        //-2 -4 2 4
        // i>=0 && i<2  0 1
        // arr[1] = 2* arr[0]
        // arr[3] = 2*arr[2]
        // arr[5] = 2*arr[4]
        // 分析可得,对于每个数，遍历找到是自己2倍或者一半的数,都匹配即可
        //1 2 4 8 16 32
        //解决方法：
        //1. 先对数组进行排序Sort
        Arrays.sort(arr);
        //2. 存入list中
        ArrayList<Integer> list = new ArrayList<>();
        for(int a : arr){
            list.add(a);
        }
        //3. 双重for循环（长度为i >=0 && i < arr.length/2），遍历找到自己的2倍，找不到就false
        while(list.size()/2 > 0){
            for(int j=1; j<list.size(); j++){
                if(list.get(0)>=0){
                    if(2*list.get(0) == list.get(j)){
                        list.remove(j);
                        list.remove(0);
                        break;
                    }
                }else{
                    if(list.get(0) == 2*list.get(j)){
                        list.remove(j);
                        list.remove(0);
                        break;
                    }
                }
                if(j == list.size()-1){
                    return false;
                }
            }
        }
        return true;
    }
}
