package raxcl.structure.tree.binarytree.review;

import raxcl.structure.tree.TreeNode;

import java.util.*;

/**
 * 二叉树复习6
 *
 * @author D30100_chenlong
 * @date 2022-05-31 11:47:46
 */
public class BinaryTreeReview6 {
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,5}));
        //构建二叉树
        TreeNode treeNode = createBinaryTree6(inputList);
        System.out.println("============递归遍历==============");
        System.out.println("前序遍历");
        preOrderTraveral6(treeNode);
        System.out.println();
        System.out.println("中序遍历");
        inOrderTraveral6(treeNode);
        System.out.println();
        System.out.println("后续遍历");
        postOrderTraveral6(treeNode);
        System.out.println();
        System.out.println("==============栈遍历=============");
        System.out.println("前序遍历：");
        preOrderTraveralWithStack6(treeNode);
        System.out.println();
        System.out.println("中序遍历");
        inOrderTraveralWithStack6(treeNode);
        System.out.println();
        System.out.println("后续遍历");
        postOrderTraveralWithStack6(treeNode);
        System.out.println();
        System.out.println("===========层序遍历(队列)==============");
        levelOrderTraversal6(treeNode);
        System.out.println();
    }

    private static void levelOrderTraversal6(TreeNode treeNode) {
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(treeNode);
        while (!queue.isEmpty()){
            treeNode = queue.poll();
            System.out.print(treeNode.data+" ");
            if (treeNode.leftChild!=null){
                queue.offer(treeNode.leftChild);
            }
            if (treeNode.rightChild!=null){
                queue.offer(treeNode.rightChild);
            }
        }
    }

    private static void postOrderTraveralWithStack6(TreeNode treeNode) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode preNode = null;
        while (!stack.isEmpty() || treeNode!=null){
            while (treeNode!=null){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()){
                treeNode = stack.peek();
                if (treeNode.rightChild==preNode || treeNode.rightChild==null){
                    treeNode = stack.pop();
                    System.out.print(treeNode.data+" ");
                    preNode = treeNode;
                    treeNode=null;
                }else{
                    treeNode = treeNode.rightChild;
                }
            }
        }
    }

    private static void inOrderTraveralWithStack6(TreeNode treeNode) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (!stack.isEmpty() || treeNode!=null){
            while (treeNode!=null){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()){
                treeNode = stack.pop();
                System.out.print(treeNode.data+" ");
                treeNode = treeNode.rightChild;
            }
        }
    }

    private static void preOrderTraveralWithStack6(TreeNode treeNode) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (!stack.isEmpty() || treeNode!=null){
            while (treeNode!=null){
                System.out.print(treeNode.data+" ");
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    private static void postOrderTraveral6(TreeNode treeNode) {
        if (treeNode!=null){
            postOrderTraveral6(treeNode.leftChild);
            postOrderTraveral6(treeNode.rightChild);
            System.out.print(treeNode.data+" ");
        }
    }

    private static void inOrderTraveral6(TreeNode treeNode) {
        if (treeNode!=null){
            inOrderTraveral6(treeNode.leftChild);
            System.out.print(treeNode.data+" ");
            inOrderTraveral6(treeNode.rightChild);
        }
    }

    private static void preOrderTraveral6(TreeNode treeNode) {
        if (treeNode!=null){
            System.out.print(treeNode.data+" ");
            preOrderTraveral6(treeNode.leftChild);
            preOrderTraveral6(treeNode.rightChild);
        }
    }

    //挨个抽出，前序遍历方式构建二叉树
    private static TreeNode createBinaryTree6(LinkedList<Integer> inputList) {
        if (inputList==null || inputList.isEmpty()){
            return null;
        }
        TreeNode treeNode = null;
        Integer num = inputList.removeFirst();
        if (num!=null){
            treeNode = new TreeNode(num);
            treeNode.leftChild = createBinaryTree6(inputList);
            treeNode.rightChild = createBinaryTree6(inputList);
        }
        return treeNode;
    }
}
