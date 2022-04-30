package raxcl.structure.tree.binarytree.review;

import raxcl.structure.tree.TreeNode;

import java.util.*;

/**
 * 二叉树复习5
 *
 * @author D30100_chenlong
 * @date 2022/5/18 9:17
 */
public class BinaryTreeReview5 {
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,5}));
        //构建二叉树
        TreeNode treeNode = createBinaryTree5(inputList);
        System.out.println("============递归遍历==============");
        System.out.println("前序遍历");
        preOrderTraveral5(treeNode);
        System.out.println();
        System.out.println("中序遍历");
        inOrderTraveral5(treeNode);
        System.out.println();
        System.out.println("后续遍历");
        postOrderTraveral5(treeNode);
        System.out.println();
        System.out.println("==============栈遍历=============");
        System.out.println("前序遍历：");
        preOrderTraveralWithStack5(treeNode);
        System.out.println();
        System.out.println("中序遍历");
        inOrderTraveralWithStack5(treeNode);
        System.out.println();
        System.out.println("后续遍历");
        postOrderTraveralWithStack5(treeNode);
        System.out.println();
        System.out.println("===========层序遍历(队列)==============");
        levelOrderTraversal5(treeNode);
        System.out.println();
    }

    private static void levelOrderTraversal5(TreeNode treeNode) {
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

    private static void postOrderTraveralWithStack5(TreeNode treeNode) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode preNode = null;
        while (!stack.isEmpty() || treeNode!=null){
            while(treeNode!=null){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()){
                treeNode = stack.peek();
                if (treeNode.rightChild==preNode || treeNode.rightChild==null){
                    treeNode = stack.pop();
                    System.out.print(treeNode.data+" ");
                    preNode = treeNode;
                    treeNode = null;
                }else{
                    treeNode = treeNode.rightChild;
                }
            }
        }
    }

    private static void inOrderTraveralWithStack5(TreeNode treeNode) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
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

    private static void preOrderTraveralWithStack5(TreeNode treeNode) {
      Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
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

    private static void postOrderTraveral5(TreeNode treeNode) {
        if (treeNode!=null){
            postOrderTraveral5(treeNode.leftChild);
            postOrderTraveral5(treeNode.rightChild);
            System.out.print(treeNode.data+" ");
        }
    }

    private static void inOrderTraveral5(TreeNode treeNode) {
        if (treeNode!=null){
            inOrderTraveral5(treeNode.leftChild);
            System.out.print(treeNode.data+" ");
            inOrderTraveral5(treeNode.rightChild);
        }
    }

    private static void preOrderTraveral5(TreeNode treeNode) {
        if (treeNode!=null){
            System.out.print(treeNode.data+" ");
            preOrderTraveral5(treeNode.leftChild);
            preOrderTraveral5(treeNode.rightChild);
        }
    }

    //挨个抽出，
    private static TreeNode createBinaryTree5(LinkedList<Integer> inputList) {
        if (inputList==null || inputList.isEmpty()){
            return null;
        }
        TreeNode treeNode =null;
        Integer num = inputList.removeFirst();
        if (num!=null){
            treeNode = new TreeNode(num);
            treeNode.leftChild = createBinaryTree5(inputList);
            treeNode.rightChild = createBinaryTree5(inputList);
        }
        return treeNode;
    }
}
