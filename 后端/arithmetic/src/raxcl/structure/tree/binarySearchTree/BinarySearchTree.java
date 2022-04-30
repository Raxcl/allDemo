package raxcl.structure.tree.binarySearchTree;

import raxcl.structure.tree.TreeNode;

/**
 * 二叉查找树
 *
 * @author D30100_chenlong
 * @date 2022/4/26 16:07
 */
public class BinarySearchTree {

    private TreeNode root;

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] input = {6,3,8,2,5,7,9,1,4};
        for (int j : input) {
            binarySearchTree.insert(j);
        }
        inOrderTraveral(binarySearchTree.root);
        System.out.println();
        System.out.println(binarySearchTree.search(3));
        System.out.println(binarySearchTree.delete(3));
        System.out.println(binarySearchTree.search(3));
        System.out.println(binarySearchTree.delete(6));
        inOrderTraveral(binarySearchTree.root);
    }

    //查找节点
    public TreeNode search(int data){
        TreeNode targetNode = root;
        while(targetNode!=null && targetNode.data !=data){
            if (data > targetNode.data){
                targetNode = targetNode.rightChild;
            }else{
                targetNode = targetNode.leftChild;
            }
        }
        return targetNode;
    }

    //中序遍历
    public static void inOrderTraveral(TreeNode treeNode){
        if (treeNode != null){
            inOrderTraveral(treeNode.leftChild);
            System.out.print(treeNode.data+" ");
            inOrderTraveral(treeNode.rightChild);
        }
    }

    //插入节点
    public void insert(int data){
        TreeNode treeNode = new TreeNode(data);
        if (root==null){
            root = treeNode;
            return ;
        }
        TreeNode targetNode = root;
        while(targetNode!= null){
            if (data == targetNode.data){
                System.out.println("二叉查找数中已有重复的节点："+ data);
                return ;
            }else if (data > targetNode.data){
                if (targetNode.rightChild == null){
                    targetNode.rightChild = treeNode;
                    return ;
                }
                targetNode = targetNode.rightChild;
            }else{
                if (targetNode.leftChild == null){
                    targetNode.leftChild = treeNode;
                    return ;
                }
               targetNode = targetNode.leftChild;
            }
        }
    }

    private boolean delete(int data) {
        TreeNode targetNode = root;
        TreeNode parentNode = null;
        //判断待删除节点是否存在
        while(targetNode.data !=data){
            parentNode = targetNode;
            if (data > targetNode.data){
                targetNode = targetNode.rightChild;
            }else{
                targetNode = targetNode.leftChild;
            }
            if (targetNode == null){
                //没有找到待删除节点
                return false;
            }
        }
        //待删除节点没有子节点
        if (targetNode.leftChild==null && targetNode.rightChild==null){
            if (targetNode == root){
                //待删除节点是根节点
                root = null;
            }else{
                if (parentNode.leftChild == targetNode){
                    parentNode.leftChild =null;
                }else{
                    parentNode.rightChild = null;
                }
            }
            //待删除结点有一个子节点（右）
        }else if(targetNode.leftChild ==null){
            if(targetNode == root){
                root = targetNode.rightChild;
            }else if(parentNode.rightChild == targetNode){
                parentNode.rightChild = targetNode.rightChild;
            }else{
                parentNode.leftChild = targetNode.rightChild;
            }
            //待删除节点有一个子节点（左）
        }else if(targetNode.rightChild == null){
            if (targetNode == root){
                root = targetNode.leftChild;
            }else if(parentNode.rightChild == targetNode){
                parentNode.rightChild = targetNode.leftChild;
            }else{
                parentNode.leftChild = targetNode.leftChild;
            }
            //待删除结点有两个子结点
        }else{
            //待删除结点的后继结点的父结点
            TreeNode successParentNode = targetNode;
            //待删除结点的后继结点
            TreeNode successNode = targetNode.rightChild;
            while(successNode.leftChild !=null){
                successParentNode = successNode;
                successNode = successNode.leftChild;
            }
            //把后继结点复制到待删除结点位置
            targetNode.data = successNode.data;
            //删除后继结点
            if (successParentNode.rightChild == successNode){
                successParentNode.rightChild = successNode.rightChild;
            }else{
                successParentNode.leftChild = successNode.rightChild;
            }
        }
        return true;
    }
}
