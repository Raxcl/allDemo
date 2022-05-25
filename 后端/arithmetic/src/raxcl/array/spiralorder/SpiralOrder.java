package raxcl.array.spiralorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 螺旋遍历二维数组
 *
 * @author D30100_chenlong
 * @date 2022/5/19 16:42
 */
public class SpiralOrder {
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
        //当二维数组是空或任何一个维度是0， 直接返回
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return list;
        }
        //m是矩阵的行数
        int m = matrix.length;
        //n是矩阵的列数
        int n = matrix[0].length;
        //二维数组的层数，取决于行和列的较小值
        int size = (Math.min(m,n)+1)/2;
        //大循环，从外向内逐层遍历矩阵
        for (int i = 0; i < size; i++) {
            //从左到右遍历“上边”
            for (int j = i; j < n-i; j++) {
                list.add(matrix[i][j]);
            }
            //从上到下遍历的“右边”
            for(int j=i+1; j<m-i; j++){
                list.add(matrix[j][n-1-i]);
            }
            //从右到左遍历“下边”
            for (int j=i+1; j<n-i && m-1-i>i; j++){
                list.add(matrix[m-1-i][n-1-j]);
            }
            //从下到上遍历“左边”
            for (int j=i+1; j<m-1-i && i<(n-1)-i; j++){
                list.add(matrix[m-1-j][i]);
            }
        }
        return list;
    }






















}
