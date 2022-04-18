package raxcl.structure.tree.binarytree.review;


import raxcl.structure.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的遍历复习1
 *
 * @author D30100_chenlong
 * @date 2022/4/12 16:35
 */
public class BinaryTreeReview1 {
    //二叉树深度遍历
    //1. 递归（前序中序后序）
    //2. 栈（前序中序后序）
    //二叉树层序遍历（队列）
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        //构建二叉树
        TreeNode treeNode = createBinaryTree1(inputList);
        System.out.println("============递归遍历==============");
        System.out.println("前序遍历");
        preOrderTraveral1(treeNode);
        System.out.println();
        System.out.println("中序遍历");
        inOrderTraveral1(treeNode);
        System.out.println();
        System.out.println("后续遍历");
        postOrderTraveral1(treeNode);
        System.out.println();
        System.out.println("==============栈遍历=============");
        System.out.println("前序遍历：");
        preOrderTraveralWithStack1(treeNode);
        System.out.println();
        System.out.println("中序遍历");
        inOrderTraveralWithStack1(treeNode);
        System.out.println();
        System.out.println("后续遍历");
        postOrderTraveralWithStack1(treeNode);
        System.out.println();
        System.out.println("===========层序遍历(队列)==============");
        levelOrderTraversal1(treeNode);
        System.out.println();
    }

    //构建二叉树
    private static TreeNode createBinaryTree1(LinkedList<Integer> inputList) {
        if(inputList==null || inputList.isEmpty()){
            return null;
        }
        TreeNode treeNode = null;
        Integer data = inputList.removeFirst();
        if(data!=null){
            treeNode = new TreeNode(data);
            treeNode.leftChild = createBinaryTree1(inputList);
            treeNode.rightChild = createBinaryTree1(inputList);
        }
        return treeNode;
    }
    private static void preOrderTraveral1(TreeNode treeNode) {
        if(treeNode!=null){
            System.out.print(treeNode.data+" ");
            preOrderTraveral1(treeNode.leftChild);
            preOrderTraveral1(treeNode.rightChild);
        }
    }
    private static void inOrderTraveral1(TreeNode treeNode) {
        if (treeNode==null){
            return;
        }
        inOrderTraveral1(treeNode.leftChild);
        System.out.print(treeNode.data+" ");
        inOrderTraveral1(treeNode.rightChild);
    }
    private static void postOrderTraveral1(TreeNode treeNode) {
        if (treeNode==null){
            return;
        }
        postOrderTraveral1(treeNode.leftChild);
        postOrderTraveral1(treeNode.rightChild);
        System.out.print(treeNode.data+" ");
    }
    private static void preOrderTraveralWithStack1(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || treeNode!=null) {
            while (treeNode != null) {
                System.out.print(treeNode.data + " ");
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    private static void inOrderTraveralWithStack1(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || treeNode!=null){
            while(treeNode!=null){
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

    private static void postOrderTraveralWithStack1(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(!stack.isEmpty() || treeNode!=null){
            while(treeNode!=null){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            treeNode = stack.peek();
            if(treeNode.rightChild!=null && treeNode.rightChild!= pre){
                treeNode = treeNode.rightChild;
            }else{
                treeNode = stack.pop();
                System.out.print(treeNode.data+" ");
                pre=treeNode;
                treeNode=null;
            }
        }
    }

    private static void levelOrderTraversal1(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        while(!queue.isEmpty()){
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














}
