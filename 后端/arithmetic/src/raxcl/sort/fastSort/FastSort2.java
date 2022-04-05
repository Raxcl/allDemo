package raxcl.sort.fastSort;

import java.util.Arrays;

/**
 * 快速排序 进阶， 二维数组
 * start 2022-04-01 13:15:52
 *
 * @author D30100_chenlong
 * @date 2022/3/31 17:38
 */
public class FastSort2 {
    public static void main(String[] args) {
        int[][] arr = {{1,0},{2,2},{5,3},{1,4},{2,5},{7,6},{44,7},{6,8},{8,9},{22,10},{12,11}};
        System.out.print("排序前：");
        for(int[] temp: arr){
            System.out.print(temp[0]+",");
        }
        FastSort2 fastSort = new FastSort2();
        fastSort.fastSort(arr,0,arr.length-1);
        System.out.println();
        System.out.print("排序后：");
        for(int[] temp: arr){
            System.out.print(temp[0]+",");

        }
    }

    private void fastSort(int[][] arr, int l, int r){
        if (l<r){
            int pos = fastSortArr(arr, l,r);
            fastSort(arr,l,pos-1);
            fastSort(arr,pos+1, r);
        }
    }

    private int fastSortArr(int[][] arr, int l, int r){
        int temp = (int)(Math.random()*(r-l+1))+l;
        int pos = l;
        //将temp点放到最右边
        swap(arr,temp, r);
        for (int i=l; i<r; i++){
            if(arr[i][0] < arr[r][0]){
                swap(arr, i, pos);
                pos++;
            }
        }
        //将基准点放回去
        swap(arr,pos, r);
        return pos;
    }
    private void swap(int[][] arr, int a, int b){
        int[] temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
