package raxcl.structure.tree.binarytree;

import raxcl.structure.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 利用栈遍历二叉树
 *
 * @author D30100_chenlong
 * @date 2022/4/10 14:58
 */
public class StackTraverse {
    /**
     * 二叉树非递归前序遍历
     * @param root
     */
    public static void preOrderTraveralWithStack(TreeNode root){
        Stack<TreeNode> stack = new Stack();
         TreeNode treeNode = root;
        while(treeNode!=null || !stack.isEmpty()){
            //迭代访问节点的左孩子，并入栈
            while(treeNode != null){
                System.out.print(treeNode.data+" ");
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if(!stack.isEmpty()){
                treeNode = stack.pop();
            }
            treeNode = treeNode.rightChild;
        }
    }

    /**
     * 二叉树中序遍历
     */
    public static void inOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while(treeNode !=null || !stack.isEmpty()){
            //迭代访问左孩子，入栈
            while(treeNode !=null){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //左孩子为空时,根出栈，输出
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                System.out.print(treeNode.data+" ");
            }
            //右孩子
            treeNode = treeNode.rightChild;
        }
    }

    /**
     * 二叉树的后续遍历
     */
    public static void postOrderTraveralWithStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        TreeNode pre = null;
        while(treeNode!=null || !stack.isEmpty()){
            //遍历到最左孩子，为空，出栈根，访问右孩子，为空就输出根
            while(treeNode!=null){
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            treeNode = stack.peek();
            //右孩子不为空且不是栈顶元素（没有被遍历过），就遍历右孩子，否则输出当前节点
            if (treeNode.rightChild!=null && treeNode.rightChild!=pre){
                treeNode = treeNode.rightChild;
            }else{
                if (!stack.isEmpty()){
                    treeNode = stack.pop();
                    System.out.print(treeNode.data + " ");
                    pre = treeNode;
                    treeNode = null;
                }
            }
        }
    }


    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{1,2,4,null,null,5,null,null,3,null,6}));
        TreeNode treeNode = Recursion.createBinaryTree(inputList);
        System.out.println();
        System.out.println("前序遍历：");
        preOrderTraveralWithStack(treeNode);
        System.out.println();
        System.out.println("中序遍历");
        inOrderTraveralWithStack(treeNode);
        System.out.println();
        System.out.println("后续遍历");
        postOrderTraveralWithStack(treeNode);
        System.out.println();

    }

}
