package raxcl.link.middleNode;

import raxcl.link.ListNode;

/**
 * 找出链表的中间节点 如果有两个中间节点，用第二个
 * @author D30100_chenlong
 * @date 2022/3/30 13:20
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        //1. 采用快慢指针方式
        //2. 获取指针长度，如果是偶数，返回慢指针加一,否则直接返回慢指针
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast.next != null){
            slow = slow.next;
        }
        return slow;
    }
}
