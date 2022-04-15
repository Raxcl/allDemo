package raxcl.sort.quick;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 快速排序
 *
 * @author D30100_chenlong
 * @date 2022/4/13 16:11
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,4,6,5,3,2,8,4,1};
        quickSort(arr,0,arr.length-1);
//        quickSort1(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //递归方式
    private static void quickSort(int[] arr, int startIndex, int endIndex) {
        if(startIndex<endIndex){
            //得到基准值
            int pivotIndex = partition(arr,startIndex,endIndex);
//            int pivotIndex = partition1(arr,startIndex,endIndex);
            //根据基准元素，分成两部分进行递归排序
            quickSort(arr,startIndex,pivotIndex-1);
            quickSort(arr,pivotIndex+1,endIndex);
        }
    }

    //栈
    public static void quickSort1(int[] arr, int startIndex, int endIndex){
        //用一个集合栈来代替递归的函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        //整个数列的起止下标，以哈希的形式入栈
        Map rootParam = new HashMap();
        rootParam.put("startIndex",startIndex);
        rootParam.put("endIndex",endIndex);
        quickSortStack.push(rootParam);
        //循环结束条件：栈为空时
        while(!quickSortStack.isEmpty()){
            Map<String, Integer> param = quickSortStack.pop();
            //得到基准元素位置
            int pivotIndex = partition(arr, param.get("startIndex"),param.get("endIndex"));
            if(param.get("startIndex")< pivotIndex-1){
                Map<String,Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex",param.get("startIndex"));
                leftParam.put("endIndex", pivotIndex-1);
                quickSortStack.push(leftParam);
            }
            if(pivotIndex+1 < param.get("endIndex")){
                Map<String,Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivotIndex+1);
                rightParam.put("endIndex",param.get("endIndex"));
                quickSortStack.push(rightParam);
            }

        }

    }

    //双边循环法
    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while(left!=right){
            //移动右指针
            while(left<right && arr[right]>=pivot){
                right--;
            }
            //移动左指针
            while(left<right && arr[left]<=pivot){
                left++;
            }
            if (left<right){
                //交换
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

    //单边循环
    //定义一个指针index指向开头，遍历，遇到小于基准值就index++，并交换
    private static int partition1(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int mark = startIndex;
        for (int i=startIndex+1;i<=endIndex;i++){
            if (arr[i]<pivot){
                int temp = arr[++mark];
                arr[mark] = arr[i];
                arr[i] = temp;
            }
        }
        //将基准值放回中间
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

}
