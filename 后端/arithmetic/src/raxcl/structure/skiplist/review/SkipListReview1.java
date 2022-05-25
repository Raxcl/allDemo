package raxcl.structure.skiplist.review;


import java.util.ArrayList;
import java.util.Random;

/**
 * 跳表复习1
 *
 * @author D30100_chenlong
 * @date 2022-05-10 13:26:16
 */
public class SkipListReview1 {
    private Node head,tail;
    private int maxLevel;

    public SkipListReview1(){
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.right = tail;
        tail.left = head;
    }

    public class Node{
        public int data;
        //跳表结点的前后和上下都有指针
        public Node up, down, left, right;
        public Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        SkipListReview1 list = new SkipListReview1();
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
        list.allPrintList();
        list.search(5000);
        System.out.println(list.remove(50)?"删除结点成功":"删除结点失败");
        list.search(50);
        list.allPrintList();
    }

    //构建完整跳表
    private void allPrintList() {
        System.out.println("====输出完整跳表====");
        //封装底层链表
        ArrayList<Node> list = new ArrayList<>();
        Node node = head;
        while(node.down!=null){
            node = node.down;
        }
        while (node.right.data!=Integer.MAX_VALUE){
            list.add(node.right);
            node = node.right;
        }
        //求出长度，定义二维数组，初始化,并用node数组做中间判断
        int[][] array = new int[maxLevel][list.size()];
        Node[] nodeArray = new Node[list.size()];
        //将list值赋值过来
        int index =0;
        for (Node node1: list){
            nodeArray[index] = node1.up;
            array[maxLevel-1][index] = node1.data;
            index++;
        }
        //字底向上赋值
        for (int i=maxLevel-2; i>=0; i--){
            for (int j = 0; j < array[0].length; j++) {
                //更新node数组
                if (nodeArray[j]!=null){
                    array[i][j] = nodeArray[j].data;
                    nodeArray[j] = nodeArray[j].up;
                }else{
                    array[i][j] = 0;
                }
            }
        }
        //输出
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j]==0){
                    System.out.print("     ");
                }else{
                    System.out.printf("%-5d",array[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("====输出结束====");
    }

    //删除结点
    public boolean remove(int data){
        Node removeNode = findNode(data);
        if (removeNode == null){
            return false;
        }
        int currentLevel = 0;
        while(removeNode != null){
            removeNode.right.left = removeNode.left;
            removeNode.left.right = removeNode.right;
            //如果不是最底层，且只有无穷小和无穷大结点，删除该层
            if (currentLevel !=0 && removeNode.left.data == Integer.MIN_VALUE && removeNode.right.data == Integer.MAX_VALUE){
                removeLevel(removeNode.left);
            }else{
                currentLevel++;
            }
            removeNode = removeNode.up;
        }
        return true;
    }

    //删除一层
    private void removeLevel(Node leftNode) {
        Node rightNode = leftNode.right;
        //如果删除层是最高层
        if (leftNode.up==null){
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


    //输出底层链表
    public void printList(){
        Node node = head;
        while (node.down!=null){
            node = node.down;
        }
        while(node.right.data != Integer.MAX_VALUE){
            System.out.print(node.right.data + " ");
            node = node.right;
        }
        System.out.println();
    }

    //查找结点
    public Node search(int data){
        Node p = findNode(data);
        if (p.data == data){
            System.out.println("找到结点："+ data);
            return p;
        }
        System.out.println("未找到结点："+ data);
        return null;
    }

    private void insert(int data) {
        //如果没找到，跳表结点就在data左边或者右下角
        Node preNode = findNode(data);
        //如果data相同，直接返回
        if(preNode.data == data){
            return;
        }
        Node node = new Node(data);
        appendNode(preNode, node);
        int currentLevel=0;
        //随机决定结点是否晋升
        Random random = new Random();
        while (random.nextDouble()<0.5){
            //如果当前层已经是最高层，需要增加一层
            if (currentLevel == maxLevel){
                addLevel();
            }
            //找到上一层的前置节点
            while(preNode.up == null){
                preNode = preNode.left;
            }
            preNode = preNode.up;
            //把晋升的新结点的插入到上一层
            Node upperNode = new Node(data);
            appendNode(preNode, upperNode);
            upperNode.down = node;
            node.up = upperNode;
            node = upperNode;
            currentLevel++;
        }
    }

    private void addLevel(){
        maxLevel++;
        Node p1 = new Node(Integer.MIN_VALUE);
        Node p2 = new Node(Integer.MAX_VALUE);
        p1.right = p2;
        p2.left = p1;
        p1.down = head;
        head.up = p1;
        p2.down = tail;
        tail.up = p2;
        head = p1;
        tail = p2;
    }

    //在前面节点后面添加新结点
    private void appendNode(Node preNode, Node newNode) {
        newNode.left = preNode;
        newNode.right=preNode.right;
        preNode.right.left = newNode;
        preNode.right = newNode;
    }

    private Node findNode(int data) {
        Node node = head;
        while(true){
            while(node.right.data!=Integer.MAX_VALUE && node.right.data<=data){
                node = node.right;
            }
            if (node.down ==null){
                break;
            }
            node = node.down;
        }
        return node;
    }
}
