package raxcl.sort.quick.review;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 快速排序第一轮复习
 *
 * @author D30100_chenlong
 * @date 2022/4/14 11:17
 */
public class QuickSortReview1 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,4,6,5,3,2,8,1};
        quickSort01(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{4,4,6,5,3,2,8,1};
        quickSort02(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{4,4,6,5,3,2,8,1};
        quickSort11(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{4,4,6,5,3,2,8,1};
        quickSort12(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }



    //递归
    private static void quickSort01(int[] arr, int startIndex, int endIndex) {
        if (startIndex<endIndex){
            int pivot = partition1(arr,startIndex,endIndex);
            quickSort01(arr,startIndex,pivot-1);
            quickSort01(arr,pivot+1,endIndex);
        }
    }
    private static void quickSort02(int[] arr, int startIndex, int endIndex) {
        if (startIndex<endIndex){
            int pivot = partition2(arr,startIndex,endIndex);
            quickSort02(arr,startIndex,pivot-1);
            quickSort02(arr,pivot+1,endIndex);
        }
    }

    //栈
    private static void quickSort11(int[] arr, int startIndex, int endIndex) {
        //用一个集合栈来代替递归的函数栈
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex",startIndex);
        rootParam.put("endIndex",endIndex);
        stack.push(rootParam);
        while(!stack.isEmpty()){
            Map<String, Integer> param = stack.pop();
            int pivotIndex = partition1(arr,param.get("startIndex"),param.get("endIndex"));
            if(param.get("startIndex")<pivotIndex-1){
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex",startIndex);
                leftParam.put("endIndex",pivotIndex-1);
                stack.push(leftParam);
            }
            if(pivotIndex+1<param.get("endIndex")){
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex",pivotIndex+1);
                rightParam.put("endIndex",endIndex);
                stack.push(rightParam);
            }

        }
    }

    private static void quickSort12(int[] arr, int startIndex, int endIndex) {
        //用一个集合栈来代替递归的函数栈
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex",startIndex);
        rootParam.put("endIndex",endIndex);
        stack.push(rootParam);
        while(!stack.isEmpty()){
            Map<String, Integer> param = stack.pop();
            int pivotIndex = partition2(arr,param.get("startIndex"),param.get("endIndex"));
            if(param.get("startIndex")<pivotIndex-1){
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex",startIndex);
                leftParam.put("endIndex",pivotIndex-1);
                stack.push(leftParam);
            }
            if(pivotIndex+1<param.get("endIndex")){
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex",pivotIndex+1);
                rightParam.put("endIndex",endIndex);
                stack.push(rightParam);
            }

        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;

    }

    //双边循环法
    private static int partition2(int[] arr, int startIndex, int endIndex) {
        int left = startIndex;
        int right = endIndex;
        //选取随机一个值作为基准值
        int randomIndex = (int)(Math.random()*(endIndex-startIndex+1))+startIndex;
        swap(arr,startIndex,randomIndex);
        int pivot = arr[startIndex];
        while(left!=right){
            //右指针移动
            while(left<right && arr[right]>=pivot){
                right--;
            }
            //左指针移动
            while(left<right && arr[left]<=pivot){
                left++;
            }
            if (left<right){
                swap(arr,left,right);
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

    //单边循环法
    private static int partition1(int[] arr, int startIndex, int endIndex) {
        int mark = startIndex;
        int random = (int)(Math.random()*(endIndex-startIndex+1))+startIndex;
        swap(arr,startIndex, random);
        int pivot = arr[startIndex];
        for(int i=startIndex;i<=endIndex; i++){
            if (arr[i]<pivot){
                mark++;
                swap(arr,mark,i);
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }
}
