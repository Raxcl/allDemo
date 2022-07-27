//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
//
// Related Topics 数组 矩阵 模拟 👍 436 👎 0

package leetcode.editor.cn;

//顺时针打印矩阵
public class ShunShiZhenDaYinJuZhenLcof{
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
        solution.spiralOrder(new int[][]{{1}});
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[]{};
        // 顺时针遍历 + used数组
        // 定义指针 i = 0, j = 0.
        int m = matrix.length, n = matrix[0].length;
        int up = 0, down = m - 1, left = 0, right = n - 1, index = 0;
        int[] res = new int[m * n];
        while (index < m * n ) {
            // 右
            if (up <= down) {
                for (int i = left; i <= right; i++) {
                    res[index++] = matrix[up][i];
                }
                up++;
            }

            // 下
            if (left <= right) {
                for (int i = up; i <= down; i++) {
                    res[index++] = matrix[i][right];
                }
                right--;
            }

            // 左
            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    res[index++] = matrix[down][i];
                }
                down--;
            }

            // 上
            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    res[index++] = matrix[i][left];
                }
                left++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
