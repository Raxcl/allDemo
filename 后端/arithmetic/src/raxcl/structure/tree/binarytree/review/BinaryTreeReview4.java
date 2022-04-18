package raxcl.structure.tree.binarytree.review;

import raxcl.structure.tree.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树复习4
 *
 * @author D30100_chenlong
 * @date 2022/4/18 9:17
 */
public class BinaryTreeReview4 {
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        //构建二叉树
        TreeNode treeNode = createBinaryTree4(inputList);
        System.out.println("============递归遍历==============");
        System.out.println("前序遍历");
        preOrderTraveral4(treeNode);
        System.out.println();
        System.out.println("中序遍历");
        inOrderTraveral4(treeNode);
        System.out.println();
        System.out.println("后续遍历");
        postOrderTraveral4(treeNode);
        System.out.println();
        System.out.println("==============栈遍历=============");
        System.out.println("前序遍历：");
        preOrderTraveralWithStack4(treeNode);
        System.out.println();
        System.out.println("中序遍历");
        inOrderTraveralWithStack4(treeNode);
        System.out.println();
        System.out.println("后续遍历");
        postOrderTraveralWithStack4(treeNode);
        System.out.println();
        System.out.println("===========层序遍历(队列)==============");
        levelOrderTraversal4(treeNode);
        System.out.println();
    }

    private static void levelOrderTraversal4(TreeNode treeNode) {
        Deque<TreeNode> queue = new LinkedList<>();
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

    private static void postOrderTraveralWithStack4(TreeNode treeNode) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode preNode = null;
        while(!stack.isEmpty() || treeNode!=null){
            while (treeNode!=null){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()){
                treeNode = stack.peek();
                if (treeNode.rightChild!=null && treeNode.rightChild!=preNode){
                    treeNode = treeNode.rightChild;
                }else {
                    treeNode = stack.pop();
                    System.out.print(treeNode.data+" ");
                    preNode = treeNode;
                    treeNode =null;
                }
            }
        }
    }

    private static void inOrderTraveralWithStack4(TreeNode treeNode) {
        Deque<TreeNode> stack = new LinkedList<>();
        while(!stack.isEmpty() || treeNode !=null){
            while (treeNode!=null){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                System.out.print(treeNode.data+" ");
                treeNode = treeNode.rightChild;
            }
        }

    }

    private static void preOrderTraveralWithStack4(TreeNode treeNode) {
        Deque<TreeNode> stack = new LinkedList<>();
        while(!stack.isEmpty() || treeNode!=null){

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

    private static void postOrderTraveral4(TreeNode treeNode) {
        if (treeNode!=null){
            postOrderTraveral4(treeNode.leftChild);
            postOrderTraveral4(treeNode.rightChild);
            System.out.print(treeNode.data+" ");
        }
    }

    private static void inOrderTraveral4(TreeNode treeNode) {
        if (treeNode!=null){
            inOrderTraveral4(treeNode.leftChild);
            System.out.print(treeNode.data+" ");
            inOrderTraveral4(treeNode.rightChild);
        }
    }

    private static void preOrderTraveral4(TreeNode treeNode) {
        if (treeNode!=null){
            System.out.print(treeNode.data+" ");
            preOrderTraveral4(treeNode.leftChild);
            preOrderTraveral4(treeNode.rightChild);
        }
    }

    //挨个抽出，
    private static TreeNode createBinaryTree4(LinkedList<Integer> inputList) {
        if (inputList==null || inputList.isEmpty()){
            return null;
        }
        Integer number = inputList.removeFirst();
        TreeNode treeNode = null;
        if (number!=null){
            treeNode = new TreeNode(number);
            treeNode.leftChild = createBinaryTree4(inputList);
            treeNode.rightChild = createBinaryTree4(inputList);
        }
        return treeNode;
    }
}
