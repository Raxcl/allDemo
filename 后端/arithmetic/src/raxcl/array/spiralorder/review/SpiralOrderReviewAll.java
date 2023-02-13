package raxcl.array.spiralorder.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Raxcl
 * @date 2023/2/13 10:02
 */
public class SpiralOrderReviewAll {
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
        if (matrix==null || matrix.length==0 || matrix[0].length==0) {
            return list;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int size = (Math.min(m,n)+1)/2;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < n - 1; j++) {
                list.add(matrix[i][j]);
            }
            for (int j = i+1; j<m-i;j++) {
                list.add(matrix[j][n-1-i]);
            }
            for (int j=i+1;j<n-i && m-1-i >i; j++){
                list.add((matrix[m-1-i][n-1-j]));
            }
            for (int j=i+1; j<m-1-i && i<(n-1)-i;j++){
                list.add(matrix[m-1-j][i]);
            }
        }
        return list;
    }
}
