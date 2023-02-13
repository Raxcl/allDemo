package raxcl.structure.tree.allReview.binarytree;


import raxcl.structure.tree.allReview.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树遍历总复习
 */
public class BinaryTreeAllReview {
    //二叉树深度遍历
    //1. 递归（前序中序后序）
    //2. 栈（前序中序后序）
    //二叉树层序遍历（队列）
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        //构建二叉树
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("============递归遍历==============");
        System.out.println("前序遍历");
        preOrderTraveral(treeNode);
        System.out.println();
        System.out.println("中序遍历");
        inOrderTraveral(treeNode);
        System.out.println();
        System.out.println("后续遍历");
        postOrderTraveral(treeNode);
        System.out.println();
        System.out.println("==============栈遍历=============");
        System.out.println("前序遍历：");
        preOrderTraveralWithStack(treeNode);
        System.out.println();
        System.out.println("中序遍历");
        inOrderTraveralWithStack(treeNode);
        System.out.println();
        System.out.println("后续遍历");
        postOrderTraveralWithStack(treeNode);
        System.out.println();
        System.out.println("===========层序遍历(队列)==============");
        levelOrderTraversal(treeNode);
        System.out.println();
    }

    private static void postOrderTraveral(raxcl.structure.tree.allReview.TreeNode treeNode) {
        if (treeNode != null) {
            postOrderTraveral(treeNode.leftChild);
            postOrderTraveral(treeNode.rightChild);
            System.out.print(treeNode.data + " ");
        }
    }

    private static void inOrderTraveral(raxcl.structure.tree.allReview.TreeNode treeNode) {
        if (treeNode != null) {
            inOrderTraveral(treeNode.leftChild);
            System.out.print(treeNode.data + " ");
            inOrderTraveral(treeNode.rightChild);
        }
    }

    private static void preOrderTraveral(raxcl.structure.tree.allReview.TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.data + " ");
            preOrderTraveral(treeNode.leftChild);
            preOrderTraveral(treeNode.rightChild);
        }
    }

    public static raxcl.structure.tree.allReview.TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        raxcl.structure.tree.allReview.TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();

        if (data != null) {
            node = new raxcl.structure.tree.allReview.TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    private static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data+" ");
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }

    }

    private static void postOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        TreeNode pre = null;
        while(treeNode != null || !stack.isEmpty()) {
            while(treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.peek();
            }
            if (treeNode.rightChild != null && treeNode.rightChild != pre) {
                treeNode = treeNode.rightChild;
            } else {
                if (!stack.isEmpty()) {
                    treeNode = stack.pop();
                    System.out.print(treeNode.data + " ");
                    pre = treeNode;
                    treeNode = null;
                }
            }
        }
    }

    private static void inOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while(treeNode != null || !stack.isEmpty()) {
            while(treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            // 如果节点没有左孩子，则弹出栈顶节点，访问节点左孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
            }
            System.out.print(treeNode.data + " ");
            treeNode = treeNode.rightChild;
        }
    }

    private static void preOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while(treeNode != null || !stack.isEmpty()) {
            // 迭代访问节点的左孩子，并入栈
            while(treeNode != null) {
                System.out.print(treeNode.data + " ");
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            // 如果节点没有左孩子，则弹出栈顶节点，访问节点左孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
            }
            treeNode = treeNode.rightChild;
        }
    }
}
