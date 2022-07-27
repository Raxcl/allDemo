//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 0 <= nums[i] <= 10000 
// 
//
// Related Topics 数组 双指针 排序 👍 246 👎 0

package leetcode.editor.cn;

//调整数组顺序使奇数位于偶数前面
public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof{
    public static void main(String[] args) {
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        // 优化 双指针，快排思想
        int index1 = 0, index2 = nums.length - 1;
        while (index1 < index2) {
            while (index1 < index2 && (nums[index1] & 1) == 1) index1++;
            while (index1 < index2 && (nums[index2] & 1) == 0) index2--;
            if (index1 < index2) {
                int temp = nums[index1];
                nums[index1] = nums[index2];
                nums[index2] = temp;
            }
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
