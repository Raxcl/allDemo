package raxcl.structure.skiplist.review;


import java.util.Random;

/**
 * 跳表复习3
 *
 * @author D30100_chenlong
 * @date 2022-05-19 13:28:52
 */
public class SkipListReview3 {
    private Node head,tail;
    private int maxLevel;

    public SkipListReview3(){
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.right=tail;
        tail.left=head;
    }

    public class Node{
        public int data;
        public Node up,down,left,right;
        public Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        SkipListReview3 list = new SkipListReview3();
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
        list.printList();
    }

    private boolean remove(int data) {
        Node removeNode = findNode(data);
        if (removeNode.data!=data){
            return false;
        }
        int currentLevel =0;
        while(removeNode!=null){
            removeNode.left.right = removeNode.right;
            removeNode.right.left = removeNode.left;
            if (currentLevel!=0 && removeNode.left.data==Integer.MIN_VALUE && removeNode.up.data==Integer.MAX_VALUE){
                removeLevel(removeNode.left);
            }else{
                currentLevel++;
            }
            removeNode = removeNode.up;
        }
        return true;

    }

    private void removeLevel(Node leftNode) {
        Node rightNode = leftNode.right;
        if (leftNode.up!=null){
            leftNode.up.down = leftNode.down;
            leftNode.down.up = leftNode.up;
            rightNode.up.down = rightNode.down;
            rightNode.down.up = rightNode.up;
        }else{
            leftNode.down.up = null;
            rightNode.down.up = null;
        }
        maxLevel--;
    }


    //输出底层链表
    private void printList() {
        Node node = head;
        while (node.down!=null){
            node = node.down;
        }
        while (node.right.data!=Integer.MAX_VALUE){
            System.out.print(node.right.data+" ");
            node = node.right;
        }
        System.out.println();
    }



    private void insert(int data) {
        Node preNode = findNode(data);
        if (preNode.data==data){
            return;
        }
        Node node = new Node(data);
        appendNode(preNode, node);
        Random random = new Random();
        int currentLevel = 0;
        while (random.nextDouble()<0.5){
            //上浮
            if (currentLevel == maxLevel){
                addLevel();
            }
            while(preNode.up==null){
                preNode = preNode.left;
            }
            preNode = preNode.up;
            Node upperNode = new Node(data);
            node.up = upperNode;
            upperNode.down = node;
            appendNode(preNode,upperNode);
            node = upperNode;
            currentLevel++;
        }

    }

    private void addLevel() {
        Node newHead = new Node(Integer.MIN_VALUE);
        Node newTail = new Node(Integer.MAX_VALUE);
        newHead.right = newTail;
        newTail.left = newHead;
        head.up = newHead;
        newHead.down = head;
        tail.up = newTail;
        newTail.down = tail;
        head = newHead;
        tail = newTail;
        maxLevel++;
    }

    private void appendNode(Node preNode, Node node) {
        node.right = preNode.right;
        node.left = preNode;
        preNode.right.left = node;
        preNode.right = node;
    }

    private void search(int data) {
        Node node = findNode(data);
        if (node.data!=data) {
            System.out.println("未找到结点："+data);
        }else{
            System.out.println("已找到结点："+data);
        }
    }

    private Node findNode(int data) {
        Node node = head;
        while (true){
            //为什么要加=号？因为要让等于的值在node下，而不是node.right
            while(node.right.data !=Integer.MAX_VALUE && node.right.data<=data){
                node = node.right;
            }
            if (node.down==null){
                break;
            }
            node = node.down;
        }
        return node;
    }
}
