package raxcl.sort.quick.review;

import raxcl.swap.Swap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * 快速排序第二轮复习
 *
 * @author D30100_chenlong
 * @date 2022/4/15 10:01
 */
public class QuickSortReview2 {
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
            int pivot = position1(arr, startIndex, endIndex);
            quickSort01(arr,startIndex,pivot-1);
            quickSort01(arr, pivot+1, endIndex);
        }
    }

    //递归
    private static void quickSort02(int[] arr, int startIndex, int endIndex) {
        if (startIndex<endIndex){
            int pivot = position2(arr, startIndex, endIndex);
            quickSort02(arr,startIndex,pivot-1);
            quickSort02(arr, pivot+1, endIndex);
        }
    }

    //单边
    private static int position1(int[] arr, int startIndex, int endIndex) {
        int mark = startIndex;
        int random = (int)(Math.random()*(endIndex-startIndex+1))+startIndex;
        Swap.swap(arr, random , startIndex);
        int pivot = arr[startIndex];
        for (int i=startIndex; i<=endIndex; i++) {
            if (arr[i]<pivot){
                Swap.swap(arr, ++mark, i);
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    //双边
    private static int position2(int[] arr, int startIndex, int endIndex) {
        int left = startIndex;
        int right = endIndex;
        int random = (int)(Math.random()*(right-left+1))+left;
        Swap.swap(arr, random , left);
        int pivot = arr[left];
        while(left!=right){
            //右到左
            while(left<right && arr[right] >=pivot){
                right--;
            }
            //左到右
            while(left<right && arr[left] <=pivot){
                left++;
            }
            if (left<right){
                Swap.swap(arr, left , right);
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

    //栈
    private static void quickSort11(int[] arr, int startIndex, int endIndex) {
        Stack<Map<String,Integer>> stack = new Stack<>();
        Map<String,Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        stack.push(rootParam);
        while(!stack.isEmpty()){
            Map<String, Integer> param = stack.pop();
            int pivot = position1(arr, param.get("startIndex"), param.get("endIndex"));
            if (param.get("startIndex")< pivot-1){
                Map<String,Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivot-1);
                stack.push(leftParam);
            }
            if (pivot+1<param.get("endIndex")){
                Map<String,Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivot+1);
                rightParam.put("endIndex", param.get("endIndex"));
                stack.push(rightParam);
            }
        }
    }

    //栈
    private static void quickSort12(int[] arr, int startIndex, int endIndex) {
        Stack<Map<String,Integer>> stack = new Stack<>();
        Map<String,Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        stack.push(rootParam);
        while(!stack.isEmpty()){
            Map<String, Integer> param = stack.pop();
            int pivot = position2(arr, param.get("startIndex"), param.get("endIndex"));
            if (param.get("startIndex")< pivot-1){
                Map<String,Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivot-1);
                stack.push(leftParam);
            }
            if (pivot+1<param.get("endIndex")){
                Map<String,Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivot+1);
                rightParam.put("endIndex", param.get("endIndex"));
                stack.push(rightParam);
            }
        }
    }


}
