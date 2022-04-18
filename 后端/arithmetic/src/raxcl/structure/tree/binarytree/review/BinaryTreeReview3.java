package raxcl.structure.tree.binarytree.review;

import raxcl.structure.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树遍历复习3
 *
 * @author D30100_chenlong
 * @date 2022/4/15 9:20
 */
public class BinaryTreeReview3 {
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        //构建二叉树
        TreeNode treeNode = createBinaryTree3(inputList);
        System.out.println("============递归遍历==============");
        System.out.println("前序遍历");
        preOrderTraveral3(treeNode);
        System.out.println();
        System.out.println("中序遍历");
        inOrderTraveral3(treeNode);
        System.out.println();
        System.out.println("后续遍历");
        postOrderTraveral3(treeNode);
        System.out.println();
        System.out.println("==============栈遍历=============");
        System.out.println("前序遍历：");
        preOrderTraveralWithStack3(treeNode);
        System.out.println();
        System.out.println("中序遍历");
        inOrderTraveralWithStack3(treeNode);
        System.out.println();
        System.out.println("后续遍历");
        postOrderTraveralWithStack3(treeNode);
        System.out.println();
        System.out.println("===========层序遍历(队列)==============");
        levelOrderTraversal3(treeNode);
        System.out.println();
    }

    private static void levelOrderTraversal3(TreeNode treeNode) {
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

    private static void preOrderTraveralWithStack3(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || treeNode!=null){
            while(treeNode!=null){
                stack.push(treeNode);
                System.out.print(treeNode.data+" ");
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }

    }

    private static void inOrderTraveralWithStack3(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || treeNode!=null){
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

    private static void postOrderTraveralWithStack3(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode preNode = null;
        while(!stack.isEmpty() || treeNode!=null){
            while(treeNode!=null){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            treeNode = stack.peek();
            if (treeNode.rightChild!=null && treeNode.rightChild!=preNode){
                treeNode = treeNode.rightChild;
            }else {
                if (!stack.isEmpty()){
                    treeNode = stack.pop();
                    System.out.print(treeNode.data+" ");
                    preNode = treeNode;
                    treeNode = null;
                }
            }
        }
    }

    private static void preOrderTraveral3(TreeNode treeNode) {
        if (treeNode!=null){
            System.out.print(treeNode.data+" ");
            preOrderTraveral3(treeNode.leftChild);
            preOrderTraveral3(treeNode.rightChild);
        }
    }

    private static void inOrderTraveral3(TreeNode treeNode) {
        if (treeNode!=null){
            inOrderTraveral3(treeNode.leftChild);
            System.out.print(treeNode.data+" ");
            inOrderTraveral3(treeNode.rightChild);
        }

    }

    private static void postOrderTraveral3(TreeNode treeNode) {
        if (treeNode!=null){
            postOrderTraveral3(treeNode.leftChild);
            postOrderTraveral3(treeNode.rightChild);
            System.out.print(treeNode.data+" ");
        }

    }

    private static TreeNode createBinaryTree3(LinkedList<Integer> inputList) {
        if (inputList==null || inputList.isEmpty()){
            return null;
        }
        TreeNode node = null;
        Integer head = inputList.removeFirst();
        if (head!=null){
            node = new TreeNode(head);
            node.leftChild = createBinaryTree3(inputList);
            node.rightChild = createBinaryTree3(inputList);
        }
        return node;
    }
}
