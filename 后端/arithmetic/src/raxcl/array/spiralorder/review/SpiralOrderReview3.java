package raxcl.array.spiralorder.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 螺旋遍历二维数组复习3
 * @author D30100_chenlong
 * @date 2022-05-26 17:33:08
 */
public class SpiralOrderReview3 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,   2,  3,  4, 5},
                {14, 15, 16, 17, 6},
                {13, 20, 19, 18, 7},
                {12, 11, 10,  9, 8},
        };
        int[][] matrix2 = {
                {1, 2, 3},
                {12, 13, 4},
                {11, 14, 5},
                {10, 15, 6},
                {9, 8, 7},
        };
        List<Integer> resultList1 = spiralOrder(matrix);
        System.out.println(Arrays.toString(resultList1.toArray()));
        List<Integer> resultList2 = spiralOrder(matrix2);
        System.out.println(Arrays.toString(resultList2.toArray()));
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        //行
        int n = matrix.length;
        //列
        int m = matrix[0].length;
        //层级
        int size = (Math.min(m,n)+1)/2;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < m-i; j++) {
                list.add(matrix[i][j]);
            }
            for (int j = i+1; j < n-i; j++) {
                list.add(matrix[j][m-i-1]);
            }
            for (int j = i+1; j < m-i && i<n-i-1; j++) {
                list.add(matrix[n-i-1][m-j-1]);
            }
            for (int j = i+1; j <n-i-1 && i<m-i-1 ; j++) {
                list.add(matrix[n-j-1][i]);
            }
        }
        return list;
    }
}
