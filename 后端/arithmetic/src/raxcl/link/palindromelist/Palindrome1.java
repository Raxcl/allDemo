package raxcl.link.palindromelist;

import raxcl.link.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 优化1 for改为while
 */
public class Palindrome1 {
    public static void main(String[] args) {
        Palindrome1 palindrome = new Palindrome1();
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
        List<Integer> arr = new ArrayList<>();
        while(head !=null){
            arr.add(head.val);
            head = head.next;
        }
        int start = 0;
        int end = arr.size()-1;
        while(start<end){
            if(!arr.get(start).equals(arr.get(end))){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
