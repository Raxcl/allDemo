package raxcl.sort.merge;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author D30100_chenlong
 * @date 2022/4/21 14:53
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {5,8,6,3,9,2,1,7};
        mergeSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (start < end){
            //折半成两个小集合， 分别进行递归
            int mid = (start+end)/2;
            mergeSort(array, start, mid);
            mergeSort(array, mid+1, end);
            //把两个有序小集合，归并成一个大集合
            merge(array, start, mid, end);
        }
    }

    private static void merge(int[] array, int start, int mid, int end) {
        //开辟额外大集合，设置指针
        int[] tempArray = new int[end - start +1];
        int p1 = start;
        int p2 = mid +1;
        int p = 0;
        //比较两个小集合的元素，依次放入大集合
        while((p1<=mid) && (p2 <=end)){
            if (array[p1]<=array[p2]){
                tempArray[p++] = array[p1++];
            }else{
                tempArray[p++] = array[p2++];
            }
        }
        //左侧小集合还有剩余， 依次放入大集合尾部
        while(p1<=mid){
            tempArray[p++] = array[p1++];
        }
        while(p2<=end){
            tempArray[p++] = array[p2++];
        }
        //把大集合的元素复制回元素组
        System.arraycopy(tempArray, 0, array, start, tempArray.length);
    }
}
