package raxcl.sort.fastSort;

import java.util.Arrays;

/**
 * 快速排序 重写1 熟悉一下
 * start 2022-04-01 12:42
 * end 2022-04-01 13:01:58
 *
 * @author D30100_chenlong
 * @date 2022/3/31 17:38
 */
public class FastSort1 {
    public static void main(String[] args) {
        int[] arr = {1,2,5,1,2,7,44,6,8,22,12};
        System.out.println("排序前："+Arrays.toString(arr));
        FastSort1 fastSort = new FastSort1();
        fastSort.fastSort(arr,0,arr.length-1);
        System.out.println("排序后："+Arrays.toString(arr));
    }

    private void fastSort(int[] arr, int l, int r){
        if (l<r){
            int pos = fastSortArr(arr, l,r);
            fastSort(arr,l,pos-1);
            fastSort(arr,pos+1, r);
        }
    }

    private int fastSortArr(int[] arr, int l, int r){
        int temp = (int)(Math.random()*(r-l+1))+l;
        int pos = l;
        //将temp点放到最右边
        swap(arr,temp, r);
        for (int i=l; i<r; i++){
            if(arr[i] < arr[r]){
                swap(arr, i, pos);
                pos++;
            }
        }
        //将基准点放回去
        swap(arr,pos, r);
        return pos;
    }
    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
