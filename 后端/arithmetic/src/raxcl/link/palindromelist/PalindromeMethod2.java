package raxcl.link.palindromelist;

import raxcl.link.ListNode;

/**
 * 方法2 递归
 * 递归思路，递归相当于for循环的从后往前，理解这一点很重要，然后写的属性一步一步影响前面节点，主意每个适当处理每个节点的返回值
 *执行用时：13 ms
 * 内存消耗：57.9 MB
 * 由于占用了堆栈，所以比第一种方法差
 */
public class PalindromeMethod2 {
    public static void main(String[] args) {
        PalindromeMethod2 palindrome = new PalindromeMethod2();
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

    ListNode firstNode ;
    //递归
    private boolean recursive(ListNode currentNode){
        if (currentNode != null) {
            if (!recursive(currentNode.next)) {
                return false;
            }
            if (currentNode.val != firstNode.val) {
                return false;
            }
            firstNode = firstNode.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        //递归
        //start 12:10
        //做一个方法，递归调用
        firstNode = head;
        return recursive(head);
    }
}
