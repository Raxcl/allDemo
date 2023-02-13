package raxcl.link.review;

import raxcl.link.IsCycle;

import java.util.ArrayList;

public class IsCycleAllReview {
    private static class Node{
        int data;
        Node next;
        Node(int data) {
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
        while(fastNode != null && fastNode.next !=null) {
            secondNode = secondNode.next;
            fastNode = fastNode.next.next;
            if (fastNode == secondNode) {
                flag = true;
                break;
            }
        }
        ArrayList<Object> list = new ArrayList<>();
        list.add(flag);
        if (!flag){
            return list;
        }
        // 判断入环节点
        secondNode = node;
        while (fastNode != null && fastNode.next != null) {
            secondNode = secondNode.next;
            fastNode = fastNode.next;
            if (fastNode == secondNode) {
                break;
            }
        }
        Node inNode = secondNode;

        // 判断环长
        int lengthNum = 0;
        while(fastNode != null && fastNode.next != null) {
            secondNode = secondNode.next;
            fastNode = fastNode.next.next;
            lengthNum++;
            if (fastNode == secondNode) {
                break;
            }
        }

        list.add(inNode);
        list.add(lengthNum);
        return list;
    }

}
