package raxcl.sort.quick.review;

import raxcl.swap.Swap;

import java.util.*;

/**
 * 快速排序复习5
 *
 * @author D30100_chenlong
 * @date 2022-04-28 11:02:58
 */
public class QuickSortReview5 {
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

    private static void quickSort11(int[] array, int startIndex, int endIndex) {
        Deque<Map<String,Integer>> stack = new ArrayDeque<>();
        Map<String,Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        stack.push(rootParam);
        while(!stack.isEmpty()){
            Map<String,Integer> param = stack.pop();
            int pivot = partition1(array,param.get("startIndex"),param.get("endIndex"));
            if (param.get("startIndex")<pivot-1){
                Map<String,Integer> leftParam = new HashMap();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivot-1);
                stack.push(leftParam);
            }
            if (pivot+1<param.get("endIndex")){
                Map<String,Integer> rightParam = new HashMap();
                rightParam.put("startIndex", pivot+1);
                rightParam.put("endIndex", param.get("endIndex"));
                stack.push(rightParam);
            }
        }
    }

    private static void quickSort12(int[] array, int startIndex, int endIndex) {
        Deque<Map<String,Integer>> stack = new ArrayDeque<>();
        Map<String,Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        stack.push(rootParam);
        while(!stack.isEmpty()){
            Map<String,Integer> param = stack.pop();
            int pivot = partition2(array,param.get("startIndex"),param.get("endIndex"));
            if (param.get("startIndex")<pivot-1){
                Map<String,Integer> leftParam = new HashMap();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivot-1);
                stack.push(leftParam);
            }
            if (pivot+1<param.get("endIndex")){
                Map<String,Integer> rightParam = new HashMap();
                rightParam.put("startIndex", pivot+1);
                rightParam.put("endIndex", param.get("endIndex"));
                stack.push(rightParam);
            }
        }
    }

    private static void quickSort02(int[] array, int startIndex, int endIndex) {
        if (startIndex<endIndex){
            int pivot = partition2(array,startIndex,endIndex);
            quickSort02(array,startIndex,pivot-1);
            quickSort02(array,pivot+1,endIndex);
        }
    }

    private static int partition2(int[] array, int startIndex, int endIndex) {
        int random = (int)(Math.random()*(endIndex-startIndex+1))+startIndex;
        Swap.swap(array,startIndex,random);
        int pivot = array[startIndex];
        int leftIndex = startIndex;
        int rightIndex = endIndex;
        while (leftIndex!=rightIndex) {
            while(leftIndex<rightIndex && array[rightIndex]>=pivot){
                rightIndex--;
            }
            while(leftIndex<rightIndex && array[leftIndex]<=pivot){
                leftIndex++;
            }
            Swap.swap(array,leftIndex,rightIndex);
        }
        array[startIndex] = array[leftIndex];
        array[leftIndex] = pivot;
        return leftIndex;
    }

    private static void quickSort01(int[] array, int startIndex, int endIndex) {
        if (startIndex<endIndex){
            int pivot = partition1(array,startIndex,endIndex);
            quickSort01(array,startIndex,pivot-1);
            quickSort01(array,pivot+1,endIndex);
        }
    }

    private static int partition1(int[] array, int startIndex, int endIndex) {
        int mark = startIndex;
        int random = (int)(Math.random()*(endIndex-startIndex+1))+startIndex;
        Swap.swap(array,startIndex,random);
        int pivot = array[startIndex];
        for (int i = startIndex+1; i <= endIndex; i++) {
            if (array[i]<pivot){
                Swap.swap(array,++mark,i);
            }
        }
        array[startIndex] = array[mark];
        array[mark] = pivot;
        return mark;
    }
}
