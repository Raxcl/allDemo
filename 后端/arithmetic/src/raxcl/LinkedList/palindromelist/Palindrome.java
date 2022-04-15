package raxcl.LinkedList.palindromelist;

import raxcl.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断是否为回文链表    将值复制到数组中后用双指针法
 * 时间复杂度：存储数组的O(n) + 遍历O(n/2) = O(n)
 * 空间复杂度：存储数组的占用空间O(n)
 */
public class Palindrome {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
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
        //start 9:41
        //end 11:52
        //用时： 2小时11分
        //1. 将单链表存储在数组列表中
        //2. 使用回文指针进行判断（因为链表的下一个指针是逻辑，无法用下标值衡量，所以使用数组会简单些）

        //1. 将单链表存储在数组列表中
        List<Integer> arr = new ArrayList<>();
        while(head !=null){
            arr.add(head.val);
            head = head.next;
        }
        //2. 使用回文指针进行判断（因为链表的下一个指针是逻辑，无法用下标值衡量，所以使用数组会简单些）
        for(int i=0; i<= arr.size()/2; i++){
            int start = arr.get(i);
            int end = arr.get(arr.size()-1-i);
            if(start != end){
                return false;
            }
        }
        return true;
    }
}
