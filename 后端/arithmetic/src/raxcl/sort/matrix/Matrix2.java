package raxcl.sort.matrix;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 找出矩阵中最弱的k行 优化2 二分查找 + 快速选择（官方解答）
 * start 22：07
 * end
 *
 * @author D30100_chenlong
 * @date 2022/3/30 14:23
 */
public class Matrix2 {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        Matrix2 matrix2 = new Matrix2();
        int[] ints = matrix2.kWeakestRows(mat, 3);
        System.out.println(Arrays.toString(ints));
    }


    public int[] kWeakestRows(int[][] mat, int k) {
        //优化2 二分查找 + 快速选择
        //start 9：03
        //end 13:47
        //1. 使用二分统计每行军人数
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

        //将原数组从小到大排序并返回
        int[][] minimum = Helper.getLeastNumbers(power, k);
        //todo 这一步有什么用？ 还是要看一下分类比较相关的方法
        //对数组进行升序排序？
        //有问题！！！如果采用这个，那就不需要快速排序了，但如果不采用这个，结果会有问题，
        //todo 待研究
        Arrays.sort(minimum, new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                if (pair1[0] != pair2[0]) {
                    return pair1[0] - pair2[0];
                } else {
                    return pair1[1] - pair2[1];
                }
            }
        });

        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = minimum[i][1];
        }
        return ans;
    }


}

class Helper {
    public static int[][] getLeastNumbers(int[][] arr, int k) {
        //快速选择排序
        randomizedSelected(arr, 0, arr.length - 1, k);
        //封装k个arr[i][1]并返回
        int[][] vec = new int[k][2];
        for (int i = 0; i < k; ++i) {
            vec[i][0] = arr[i][0];
            vec[i][1] = arr[i][1];
        }
        return vec;

    }

    private static void randomizedSelected(int[][] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        //对当前序列使用快速排序，小的放在基准点左边，大的放在基准点右边，并返回一个基准点（快速选择了几个数值）
        int pos = randomizedPartition(arr, l, r);


        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            //对基准点左边使用快速排序
            randomizedSelected(arr, l, pos - 1, k);
        } else {
            //对基准点右边使用快速排序
            randomizedSelected(arr, pos + 1, r, k - num);
        }
    }

    //基于随机的划分
    //此方法可以和下一个方法整合，不过这样就只能基于随机的划分，而不能选择其他
    private static int randomizedPartition(int[][] nums, int l, int r) {
        //随机选取一个数作为基准点
        int i = (int) (Math.random() * (r - l + 1)) + l;
        /**
         *  nums[r]和nums[i]交换
         * 将基点放在最右边，然后遍历数组，比几点小，就一个个放在数组左边，记录一个指针指向最左边
         * 最小值不断存进来，指针慢慢向右边移动
         * 一直遍历到基点前一个结束，此时指针指向最后一个最小值
         * 将指针下一个值和最右边的基点交换，此时基点刚好回到中间
         */
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    private static int partition(int[][] nums, int l, int r) {
        int[] pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (compare(nums[j], pivot) <= 0) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    private static void swap(int[][] nums, int i, int j) {
        int[] temp = new int[nums[i].length];
        //这里是数组的交换
        System.arraycopy(nums[i], 0, temp, 0, nums[i].length);
        System.arraycopy(nums[j], 0, nums[i], 0, nums[i].length);
        System.arraycopy(temp, 0, nums[j], 0, nums[i].length);
    }



    private static int compare(int[] pair, int[] pivot) {
        if (pair[0] != pivot[0]) {
            return pair[0] - pivot[0];
        } else {
            return pair[1] - pivot[1];
        }
    }


}
