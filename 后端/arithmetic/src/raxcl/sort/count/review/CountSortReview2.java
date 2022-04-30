package raxcl.sort.count.review;

import java.util.Arrays;

/**
 * 计数排序复习2
 *
 * @author D30100_chenlong
 * @date 2022-04-27 10:11:58
 */
public class CountSortReview2 {
    public static void main(String[] args) {
        int[] array = new int[] {4,4,6,5,3,2,8,1,7,5,6,0,10};
        int[] sortedArray = countSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] countSort(int[] array) {
        //创建新数组，给出区间是d
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int d = max - min;
        //存入
        int[] result = new int[d+1];
        for (int a:array){
            result[a-min]++;
        }
        //优化
        for (int i = 1; i < result.length; i++) {
            result[i] += result[i-1];
        }
        //输出
        int[] newResult = new int[array.length];
        for (int a: array){
            newResult[result[a-min]-1] = a;
            result[a-min]--;
        }
        return newResult;

    }
}
