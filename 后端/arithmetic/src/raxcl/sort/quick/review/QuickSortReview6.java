package raxcl.sort.quick.review;

import raxcl.swap.Swap;

import java.util.*;

/**
 * 快速排序复习6
 *
 * @author D30100_chenlong
 * @date 2022-06-06 14:01:49
 */
public class QuickSortReview6 {
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
        if (startIndex<endIndex){
            int partition = partition1(array,startIndex,endIndex);
            quickSort11(array,startIndex,partition-1);
            quickSort11(array,partition+1,endIndex);
        }
    }

    private static void quickSort12(int[] array, int startIndex, int endIndex) {
        if (startIndex<endIndex){
            int partition = partition2(array,startIndex,endIndex);
            quickSort12(array,startIndex,partition-1);
            quickSort12(array,partition+1,endIndex);
        }
    }

    private static void quickSort01(int[] array, int startIndex, int endIndex) {
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        Map<String, Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        stack.push(rootParam);
        while (!stack.isEmpty()){
            Map<String, Integer> param = stack.pop();
            if (param.get("startIndex")< param.get("endIndex")){
                int pivot = partition1(array,param.get("startIndex"), param.get("endIndex") );
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivot-1);
                stack.push(leftParam);
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivot+1);
                rightParam.put("endIndex", param.get("endIndex"));
                stack.push(rightParam);
            }
        }
    }

    private static void quickSort02(int[] array, int startIndex, int endIndex) {
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        Map<String, Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        stack.push(rootParam);
        while (!stack.isEmpty()){
            Map<String, Integer> param = stack.pop();
            if (param.get("startIndex")< param.get("endIndex")){
                int pivot = partition2(array,param.get("startIndex"), param.get("endIndex") );
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIndex", param.get("startIndex"));
                leftParam.put("endIndex", pivot-1);
                stack.push(leftParam);
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIndex", pivot+1);
                rightParam.put("endIndex", param.get("endIndex"));
                stack.push(rightParam);
            }
        }
    }

    private static int partition1(int[] array, int startIndex, int endIndex) {
        int mark = startIndex;
        int random = (int)(Math.random()*(endIndex-startIndex+1))+startIndex;
        Swap.swap(array,startIndex,random);
        for (int i = startIndex+1; i <= endIndex; i++) {
            if(array[i]<array[startIndex]){
                Swap.swap(array,++mark, i);
            }
        }
        Swap.swap(array,mark, startIndex);
        return mark;
    }

    private static int partition2(int[] array, int startIndex, int endIndex) {
        int random = (int)(Math.random()*(endIndex-startIndex+1))+startIndex;
        Swap.swap(array,startIndex, random);
        int left = startIndex;
        int right = endIndex;
        while (left!=right){
            while (left<right &&  array[right]>=array[startIndex]){
                right--;
            }
            while (left<right && array[left]<=array[startIndex]){
                left++;
            }
            Swap.swap(array,left,right);
        }
        Swap.swap(array,left,startIndex);
        return left;
    }

}
