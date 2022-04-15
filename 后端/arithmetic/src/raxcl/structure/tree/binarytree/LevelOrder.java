package raxcl.structure.tree.binarytree;

import raxcl.structure.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 *
 * @author D30100_chenlong
 * @date 2022/4/11 14:53
 */
public class LevelOrder {
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{1,2,4,null,null,5,null,null,3,null,6}));
        TreeNode treeNode = Recursion.createBinaryTree(inputList);
        System.out.println();
        System.out.println("层序遍历：");
        levelOrderTraversal(treeNode);
    }

    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.data+" ");
            if (node.leftChild!=null){
                queue.offer(node.leftChild);
            }
            if (node.rightChild!=null){
                queue.offer(node.rightChild);
            }
        }
    }
}
