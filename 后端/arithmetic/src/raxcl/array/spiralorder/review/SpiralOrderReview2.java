package raxcl.array.spiralorder.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 螺旋遍历二维数组复习2
 * @author D30100_chenlong
 * @date 2022-05-23 15:22:01
 */
public class SpiralOrderReview2 {
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
        int m = matrix.length;
        int n = matrix[0].length;
        int d = (Math.min(m, n)+1)/2;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            for (int j = i; j < n-i; j++) {
                list.add(matrix[i][j]);
            }
            for (int j = i+1; j < m-i; j++) {
                list.add(matrix[j][n-1-i]);
            }
            for (int j = i+1; j < n-i && i<m-1-i; j++) {
                list.add(matrix[m-1-i][n-1-j]);
            }
            for (int j = i+1; j < m-1-i && i<n-1-i; j++) {
                list.add(matrix[m-1-j][i]);
            }
        }
        return list;
    }
}
