package raxcl.link.review;

/**
 * 是否是环，入环节点，环长
 *
 * @author D30100_chenlong
 * @date 2022/4/17 14:27
 */
public class IsCycle2 {
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

    private static int cycleLength(Node node1) {
        Node slow = node1.next;
        Node fast = node1.next.next;
        while(fast!=null && fast.next!=null){
            if (slow==fast){
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        int index = 0;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            index++;
            if (slow==fast){
                break;
            }
        }
        return index;
    }

    private static Node inCycle(Node node1) {
        Node slow = node1;
        Node fast = node1;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast){
                break;
            }
        }
        slow = node1;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;
            if (slow==fast){
                break;
            }
        }
        return slow;
    }

    private static boolean isCycle(Node node1) {
        Node slow = node1;
        Node fast = node1;
        while(fast!=null && fast.next!=null){
             slow = slow.next;
             fast = fast.next.next;
            if (slow==fast){
                return true;
            }
        }
        return false;
    }
}
