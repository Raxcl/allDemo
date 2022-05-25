package raxcl.structure.skiplist.review;


import java.util.ArrayList;
import java.util.Random;

/**
 * 跳表复习2
 *
 * @author D30100_chenlong
 * @date 2022-05-10 13:26:16
 */
public class SkipListReview2 {
    private Node head,tail;
    private int maxLevel;

    public SkipListReview2(){
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
        SkipListReview2 list = new SkipListReview2();
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
//        list.allPrintList();
        list.search(50);
        System.out.println(list.remove(50)?"删除结点成功":"删除结点失败");
        list.search(50);
//        list.allPrintList();
        list.printList();
    }

    private boolean remove(int data) {
        Node removeNode = findNode(data);
        if (removeNode.data!=data){
            return false;
        }
        int currentLevel=0;
        while (removeNode!=null){
            //删除结点
            removeNode.left.right = removeNode.right;
            removeNode.right.left = removeNode.left;
            //如果该层不是最底层，且只有一个节点，删除整层
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
        //如果是最高层
        if (leftNode.up==null){
            leftNode.down.up = null;
            rightNode.down.up =null;
            //todo 果然应该是head = 某数
            head = leftNode.down;
            tail = rightNode.down;
        }else{
            leftNode.up.down = leftNode.down;
            leftNode.down.up = leftNode.up;
            rightNode.up.down = rightNode.down;
            rightNode.down.up = rightNode.up;
        }
        maxLevel--;

    }


    //输出底层链表
    //如何输出整个跳表，尝试一下(成功，通过二维数组暂存)
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

    private void insert(int data) {
        //如果不存在，跳表结点在底层的data左边或者最右边
        Node preNode = findNode(data);
        //判断跳表中不存在插入结点
        if (preNode.data == data){
            return;
        }
        //插入最底层
        //位置合适，直接插入p的右边
        Node node = new Node(data);
        appendNode(preNode,node);
        int currentLevel = 0;
        //看概率决定是否上浮
        Random random = new Random();
        while(random.nextDouble()<0.5){
            //如果已经是最上层就增加一层
            if (currentLevel==maxLevel){
                addLevel();
            }
            while (preNode.up==null){
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
        //保证了head，tail始终在最上层
        maxLevel++;
        Node newHead = new Node(Integer.MIN_VALUE);
        Node newTail = new Node(Integer.MAX_VALUE);
        head.up = newHead;
        newHead.down = head;
        head = newHead;
        tail.up = newTail;
        newTail.down = tail;
        tail = newTail;
        head.right = tail;
        tail.left = head;
    }

    private void appendNode(Node preNode, Node node) {
        node.left = preNode;
        node.right = preNode.right;
        preNode.right.left = node;
        preNode.right=node;
    }

    private void search(int data) {
        Node p =  findNode(data);
        if(p.data == data){
            System.out.println("找到结点："+ data);
        }else{
            System.out.println("未找到结点："+ data);
        }
    }

    private Node findNode(int data) {
        Node node = head;
        while(true){
            while (node.right.data!=Integer.MAX_VALUE && node.right.data<=data){
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
