package raxcl.structure.tree.binarytree;

import raxcl.structure.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 二叉树深度优先的递归遍历
 *
 * @author D30100_chenlong
 * @date 2022/4/10 14:21
 */
public class Recursion {


    /**
     * 构建二叉树
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode node = null;
        if (inputList==null || inputList.isEmpty()){
            return null;
        }
        Integer data = inputList.removeFirst();
        //这里的判开空很关键：如果元素为空，则不再进行递归
        if(data != null){
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 二叉树前序遍历
     * @param node
     */
    public static void preOrderTraveral(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.data+" ");
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树中序遍历
     */
    public static void inOrderTraveral(TreeNode node) {
        if (node == null){
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.print(node.data+" ");
        inOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树的后续遍历
     */
    public static void postOrderTraveral(TreeNode node){
        if (node == null){
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.print(node.data+" ");
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3,2,9,null,null,10,null,null,8,null,4}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println();
        System.out.println("前序遍历：");
        preOrderTraveral(treeNode);
        System.out.println();
        System.out.println("中序遍历");
        inOrderTraveral(treeNode);
        System.out.println();
        System.out.println("后续遍历");
        postOrderTraveral(treeNode);
    }

}
