package raxcl.structure.skiplist.review;


import java.util.Random;

/**
 * 跳表复习4
 *
 * @author D30100_chenlong
 * @date 2022-05-31 10:46:42
 */
public class SkipListReview4 {
    private Node head,tail;
    private int maxLevel;

    public SkipListReview4(){
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
        SkipListReview4 list = new SkipListReview4();
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
        int currentLevel=0;
        while(removeNode!=null){
            removeNode.left.right = removeNode.right;
            removeNode.right.left = removeNode.left;
            if (currentLevel!=0 && removeNode.left.data==Integer.MIN_VALUE && removeNode.right.data==Integer.MAX_VALUE){
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
        if (leftNode.up==null){
            leftNode.down.up = null;
            rightNode.down.up = null;
        }else{
            leftNode.down.up = leftNode.up;
            leftNode.up.down = leftNode.down;
            rightNode.down.up = rightNode.up;
            rightNode.up.down = rightNode.down;
        }
        maxLevel--;
    }


    //输出底层链表
    private void printList() {
        Node node = head;
        while(node.down!=null){
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
        appendNode(preNode,node);
        Random random = new Random();
        int currentLevel = 0;
        while(random.nextDouble()<0.5){
            if (currentLevel==maxLevel){
                addLevel();
            }
            while (preNode.up==null){
                preNode = preNode.left;
            }
            preNode = preNode.up;
            Node upperNode = new Node(data);
            upperNode.down = node;
            node.up = upperNode;
            appendNode(preNode,upperNode);
            node = upperNode;
            currentLevel++;
        }

    }

    private void addLevel() {
        Node newHead = new Node(Integer.MIN_VALUE);
        Node newTail = new Node(Integer.MAX_VALUE);
        newHead.down = head;
        head.up = newHead;
        newTail.down = tail;
        tail.up = newTail;
        head = newHead;
        tail = newTail;
        head.right = tail;
        tail.left = head;
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
        if (node.data==data){
            System.out.println("找到"+data);
        }else {
            System.out.println("没找到"+data);
        }
    }

    private Node findNode(int data) {
        Node node = head;
        while(true){
            while(node.right!=null && node.right.data<=data){
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
