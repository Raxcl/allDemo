package raxcl.link.reversal;


import raxcl.link.ListNode;

/**
 * 链表翻转 递归
 *
 * @author D30100_chenlong
 * @date 2022/3/29 18:25
 */
public class Reversal {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
