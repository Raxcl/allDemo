package raxcl.structure.tree.binarytree.review;

import raxcl.structure.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的遍历第二轮复习
 *
 * @author D30100_chenlong
 * @date 2022/4/13 10:54
 */
public class BinaryTreeReview2 {
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        //构建二叉树
        TreeNode treeNode = createBinaryTree2(inputList);
        System.out.println("============递归遍历==============");
        System.out.println("前序遍历");
        preOrderTraveral2(treeNode);
        System.out.println();
        System.out.println("中序遍历");
        inOrderTraveral2(treeNode);
        System.out.println();
        System.out.println("后续遍历");
        postOrderTraveral2(treeNode);
        System.out.println();
        System.out.println("==============栈遍历=============");
        System.out.println("前序遍历：");
        preOrderTraveralWithStack2(treeNode);
        System.out.println();
        System.out.println("中序遍历");
        inOrderTraveralWithStack2(treeNode);
        System.out.println();
        System.out.println("后续遍历");
        postOrderTraveralWithStack2(treeNode);
        System.out.println();
        System.out.println("===========层序遍历(队列)==============");
        levelOrderTraversal2(treeNode);
        System.out.println();
    }

    private static void levelOrderTraversal2(TreeNode treeNode) {
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

    private static void postOrderTraveralWithStack2(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(!stack.isEmpty() || treeNode!=null){
            while(treeNode!=null){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()){
                treeNode = stack.peek();
                if (treeNode.rightChild!=null && treeNode.rightChild!=pre){
                    treeNode = treeNode.rightChild;
                }else {
                    treeNode = stack.pop();
                    System.out.print(treeNode.data+" ");
                    pre = treeNode;
                    treeNode=null;
                }
            }
        }
    }

    private static void inOrderTraveralWithStack2(TreeNode treeNode) {
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

    private static void preOrderTraveralWithStack2(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || treeNode!=null){
            while(treeNode!=null){
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

    private static void postOrderTraveral2(TreeNode treeNode) {
        if (treeNode!=null){
            postOrderTraveral2(treeNode.leftChild);
            postOrderTraveral2(treeNode.rightChild);
            System.out.print(treeNode.data+" ");
        }
    }

    private static void inOrderTraveral2(TreeNode treeNode) {
        if (treeNode!=null){
            inOrderTraveral2(treeNode.leftChild);
            System.out.print(treeNode.data+" ");
            inOrderTraveral2(treeNode.rightChild);
        }
    }

    private static void preOrderTraveral2(TreeNode treeNode) {
        if (treeNode!=null){
            System.out.print(treeNode.data+" ");
            preOrderTraveral2(treeNode.leftChild);
            preOrderTraveral2(treeNode.rightChild);
        }
    }

    private static TreeNode createBinaryTree2(LinkedList<Integer> inputList) {
        if(inputList==null || inputList.isEmpty()){
            return null;
        }
        TreeNode node = null;
        Integer head = inputList.removeFirst();
        if (head!=null){
            node = new TreeNode(head);
            node.leftChild = createBinaryTree2(inputList);
            node.rightChild = createBinaryTree2(inputList);
        }
        return node;
    }
}
