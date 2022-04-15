package raxcl.sort.topic.fastSort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author D30100_chenlong
 * @date 2022/3/31 17:38
 */
public class FastSort {
    public static void main(String[] args) {
        int[] arr = {1,2,5,1,2,7,44,6,8,22,12};

        System.out.println("快速排序前："+ Arrays.toString(arr));
        int l = 0, r=arr.length-1;
        FastSort fastSort = new FastSort();
        fastSort.fastSortMethod(arr,l,r);
        System.out.println("快速排序后："+Arrays.toString(arr));
    }

    private void fastSortMethod(int[] arr, int l, int r) {
        //4. 分而治之
        if (l<r){
            int pos = posSelect(arr,l, r);
            fastSortMethod(arr,l,pos-1);
            fastSortMethod(arr,pos+1,r);
            //todo 有漏洞，如果基点是最大值呢。怎么办
        }
    }

    private int posSelect(int[] arr, int l, int r) {
        //1. 随机一个随机数
        int ran = (int) (Math.random()*(r-l+1))+l;
        //2. 将基点放在最右边
        swap(arr,ran, r);
        //3. 开始快速排序并返回基点
        int s= l ;
        for (int i=l;i<r;i++){
            if (arr[i] < arr[r]){
                swap(arr,s,i);
                s++;
            }
        }
        swap(arr,s,r);
        return s;
    }

    private void swap(int[] arr, int pos, int r) {
        int temp = arr[pos];
        arr[pos] = arr[r];
        arr[r] = temp;
    }


}
