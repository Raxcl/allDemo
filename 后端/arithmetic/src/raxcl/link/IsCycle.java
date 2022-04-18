package raxcl.link;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 判断链表是否有环，环长和入环节点
 *
 * @author D30100_chenlong
 * @date 2022/4/15 11:55
 */
public class IsCycle {
    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        Node node6 = new Node(8);
        Node node7 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node4;
        ArrayList cycleList = isCycle(node1);
        System.out.println(cycleList.get(0));
        if ((boolean) cycleList.get(0)){
            Node inNode = (Node)cycleList.get(1);
            System.out.println(inNode.data);
            System.out.println(cycleList.get(2));
        }
    }
    private static ArrayList isCycle(Node node) {
        Node fastNode = node;
        Node secondNode = node;
        boolean flag = false;
        //判断是否有环，如果有，记录相遇节点
        while(fastNode!=null && fastNode.next!=null){
            secondNode = secondNode.next;
            fastNode = fastNode.next.next;
            if (fastNode==secondNode){
                flag =  true;
                break;
            }
        }
        ArrayList list = new ArrayList();
        list.add(flag);
        if (!flag){
            return list;
        }
        //判断入环节点
        // 2(D+s) = D+s+n(s+l)
        // D = ns+nl-s
        // D = (n-1)s+nl
        secondNode = node;
        while(fastNode!=null && fastNode.next!=null){
            secondNode = secondNode.next;
            fastNode = fastNode.next;
            if (fastNode==secondNode){
                break;
            }
        }
        Node inNode = secondNode;

        //判断环长
        int lengthNum = 0;
        while(fastNode!=null && fastNode.next!=null){
            secondNode = secondNode.next;
            fastNode = fastNode.next.next;
            lengthNum++;
            if (fastNode==secondNode){
                break;
            }
        }

        list.add(inNode);
        list.add(lengthNum);
        return list;
    }
}
