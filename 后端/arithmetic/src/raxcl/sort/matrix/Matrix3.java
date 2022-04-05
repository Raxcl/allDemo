package raxcl.sort.matrix;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 找出矩阵中最弱的k行 优化3 二分查找 + 快速选择（个人理解）
 * start 22：07
 * end
 *
 * @author D30100_chenlong
 * @date 2022/3/30 14:23
 */
//todo 待修改
public class Matrix3 {
    private int tempK;
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,0,0},{1,1,1,0,0}};
        Matrix3 matrix2 = new Matrix3();
        int[] ints = matrix2.kWeakestRows(mat, 6);
        System.out.println();
        System.out.print("返回结果为");
        System.out.println(Arrays.toString(ints));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        tempK=k;
        //1. 使用二分统计每行军人数
        int[][] power = twoSplit(mat);
        //快速排序改进版（排序需要的数量，其他不管）
        randomizedSelected(power, 0, power.length - 1);
        //返回需要的值

        for (int[] a : power){
            System.out.print(Arrays.toString(a)+",");
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = power[i][1];
        }
        return ans ;
    }

    private int[][] twoSplit(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] power = new int[m][2];
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1, pos = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (mat[i][mid] == 0) {
                    r = mid - 1;
                } else {
                    pos = mid;
                    l = mid + 1;
                }
            }
            power[i][0] = pos + 1;
            power[i][1] = i;
        }
        return power;
    }

    private void randomizedSelected(int[][] arr, int l, int r) {
        if (l < r) {
            //对当前序列使用快速排序，小的放在基准点左边，大的放在基准点右边，并返回一个基准点（快速选择了几个数值）
            int pos = randomizedPartition(arr, l, r);
            if (tempK <= pos){
                randomizedSelected(arr, l, pos-1);
            }else{
                randomizedSelected(arr, l, pos-1);
                randomizedSelected(arr, pos+1, r);
            }
        }
    }

    //基于随机的划分
    private int randomizedPartition(int[][] arr, int l, int r) {
        //随机选取一个数作为基准点
        int pos = (int) (Math.random() * (r - l + 1)) + l;
        /**
         *  nums[r]和nums[i]交换
         * 将基点放在最右边，然后遍历数组，比几点小，就一个个放在数组左边，记录一个指针指向最左边
         * 最小值不断存进来，指针慢慢向右边移动
         * 一直遍历到基点前一个结束，此时指针指向最后一个最小值
         * 将指针下一个值和最右边的基点交换，此时基点刚好回到中间
         */
        swap(arr, r, pos);
        //交换了几个数
        int temp = l;
        for (int i = l; i <= r - 1; i++) {
            //这里判断相等的情况,为了便于理解，单独拎出来
            boolean condition = (arr[i][0] == arr[r][0]) && (arr[i][1] < arr[r][1]);
            if(arr[i][0] < arr[r][0] || condition){
                swap(arr, temp, i);
                temp++;
            }
        }
        //将基点交换到中间并返回
        swap(arr, temp, r);
        return temp;
    }
    private void swap(int[][] nums, int i, int j) {
        int[] temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


