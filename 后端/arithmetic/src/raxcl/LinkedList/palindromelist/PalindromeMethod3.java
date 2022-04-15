package raxcl.LinkedList.palindromelist;

import raxcl.LinkedList.ListNode;

/**
 * 方法3 快慢指针
 * 执行用时：13 ms
 * 内存消耗：57.9 MB
 */
public class PalindromeMethod3 {
    public static void main(String[] args) {
        PalindromeMethod3 palindrome = new PalindromeMethod3();
        ListNode head = new ListNode(1);  //创建链表对象 l1 （对应有参 和 无参 构造方法）
        head.add(2); //插入节点，打印
        head.add(3);
        head.add(3);
        head.add(2);
        head.add(1);
        head.print();
        System.out.println();
        System.out.println(palindrome.isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        //start 14：53
        //end 17：09
        //快慢指针法
        //1. 找到前半部分尾节点
        ListNode firstHalfEnd = endOfFirstHalf(head);
        //2. 反转后半部分链表
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        //3. 判断是否回文

        while(secondHalfStart != null){
            if(head.val != secondHalfStart.val){
                return false;
            }
            head = head.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }

    private ListNode endOfFirstHalf(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next !=null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
