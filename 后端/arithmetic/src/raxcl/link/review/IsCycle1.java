package raxcl.link.review;


/**
 * 判断是否有环，求环长，入环节点复习1
 *
 * @author D30100_chenlong
 * @date 2022/4/16 11:25
 */
public class IsCycle1 {
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
        boolean cycle = isCycle(node1);
        System.out.println(cycle);
        if (cycle){
            System.out.println(inCycle(node1).data);
            System.out.println(cycleLength(node1));
        }
    }

    private static int cycleLength(Node node) {
        Node slow = node.next;
        Node fast = node.next.next;
        while(fast!=null && fast.next!=null){
            if (slow==fast){
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        int nodeLength = 0;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            nodeLength++;
            if (slow==fast){
                break;
            }

        }
        return nodeLength;
    }

    private static Node inCycle(Node node) {
        Node slow = node.next;
        Node fast = node.next.next;
        //相遇点
        while(fast!=null && fast.next!=null){
            if (slow==fast){
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        //入环点，a在起始点，b在像雨点，一起走最后会在入环点相遇
        slow = node;
        while(fast!=null && fast.next!=null){
            if (slow==fast){
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private static boolean isCycle(Node node) {
        Node slow = node.next;
        Node fast = node.next.next;
        while(fast!=null && fast.next!=null){
            if (slow==fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
