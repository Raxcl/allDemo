//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
//
// Related Topics 递归 链表 👍 264 👎 0

package leetcode.editor.cn;

import raxcl.link.ListNode;

//合并两个排序的链表
public class HeBingLiangGePaiXuDeLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            if (l1 != null) {
                return l1;
            } else {
                return l2;
            }
        }
        // 二者都非空，循环，比较，小的写入 res 链表
        //移动剩余进入 res
        // 存储头节点
        ListNode res1,res;
        if (l1.val <= l2.val) {
            res1 = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            res1 = new ListNode(l2.val);
            l2 = l2.next;
        }
        res = res1;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                res.next = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }

        while (l1 != null) {
            res.next = l1;
            l1 = l1.next;
            res = res.next;
        }
        while (l2 != null) {
            res.next = l2;
            l2 = l2.next;
            res = res.next;
        }
        return res1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
