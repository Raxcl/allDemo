package raxcl.structure.skiplist.review;


import raxcl.structure.skiplist.SkipList;

import java.util.Random;

/**
 * @author Raxcl
 * @date 2023/2/13 7:42
 */
public class SkipListReviewAll {
    private static final double PROMOTE_RATE = 0.5;
    private Node head,tail;
    private int maxLevel;

    public SkipListReviewAll(){
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.right = tail;
        tail.left = head;
    }

    public static void main(String[] args) {
        SkipListReviewAll list = new SkipListReviewAll();
        list.insert(50);
        list.insert(15);
        list.insert(13);
        list.insert(20);
        list.insert(100);
        list.insert(75);
        list.insert(99);
        list.insert(76);
        list.insert(83);
        list.insert(65);
        list.printList();
        list.search(50);
        System.out.println(list.remove(50)?"删除结点成功":"删除结点失败");
        list.search(50);
    }

    private boolean remove(int data) {
        Node removeNode = findNode(data);
        if (removeNode == null) {
            return false;
        }
        int currentLevel = 0;
        while (removeNode != null) {
            removeNode.right.left = removeNode.left;
            removeNode.left.right = removeNode.right;
            if (currentLevel != 0 && removeNode.left.data == Integer.MIN_VALUE && removeNode.right.data == Integer.MAX_VALUE) {
                removeLevel(removeNode.left);

            }else {
                currentLevel++;
            }
            removeNode = removeNode.up;
        }
        return true;
    }

    private void removeLevel(Node leftNode) {
        Node rightNode = leftNode.right;
        //如果删除层是最高层
        if(leftNode.up == null){
            leftNode.down = head;
            rightNode.down = tail;
            leftNode.down.up = null;
            rightNode.down.up = null;
        }else{
            leftNode.up.down = leftNode.down;
            leftNode.down.up = leftNode.up;
            rightNode.up.down = rightNode.down;
            rightNode.down.up = rightNode.up;
        }
        maxLevel--;
    }

    private void insert(int data) {
        Node preNode = findNode(data);
        if (preNode.data == data) {
            return;
        }
        Node node = new Node(data);
        appendNode(preNode, node);
        int currentLevel = 0;
        Random random = new Random();
        while(random.nextDouble() < PROMOTE_RATE) {
            if (currentLevel == maxLevel){
                addLevel();
            }
            while(preNode.up == null) {
                preNode = preNode.left;
            }
            preNode = preNode.up;
            Node upperNode = new Node(data);
            appendNode(preNode, upperNode);
            upperNode.down = node;
            node.up = upperNode;
            node = upperNode;
            currentLevel++;
        }
    }

    private void addLevel() {
        maxLevel++;
        Node p1 = new Node(Integer.MIN_VALUE);
        Node p2 = new Node(Integer.MAX_VALUE);
        p1.right = p2;
        p2.left = p1;
        p1.down = head;
        p2.down = tail;
        head.up = p1;
        tail.up = p2;
        head = p1;
        tail = p2;
    }

    private void appendNode(Node preNode, Node newNode) {
        newNode.left = preNode;
        newNode.right = preNode.right;
        preNode.right.left = newNode;
        preNode.right = newNode;
    }

    private Node findNode(int data) {
        Node node = head;
        while(true) {
            while(node.right.data !=Integer.MAX_VALUE && node.right.data <= data) {
                node = node.right;
            }
            if (node.down == null) {
                break;
            }
            node = node.down;
        }
        return node;

    }

    public Node search(int data){
        Node p = findNode(data);
        if (p.data == data) {
            System.out.println("找到节点：" + data);
            return p;
        }
        System.out.println("未找到结点：" + data);
        return null;
    }

    public class Node{
        public int data;
        public Node up,down,left,right;

        public Node(int data) {
            this.data = data;
        }
    }

    public  void printList(){
        Node node = head;
        while (node.down != null) {
            node = node.down;
        }
        while (node.right.data !=Integer.MAX_VALUE){
            System.out.print(node.right.data+ " ");
            node = node.right;
        }
        System.out.println();
    }
}
