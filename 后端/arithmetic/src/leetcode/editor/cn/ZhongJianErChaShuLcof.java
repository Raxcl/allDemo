//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 845 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//重建二叉树
public class ZhongJianErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
        solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //构建二叉树， 不断根据前序找中序的根节点，和左右树，由于没有重复值，可以用hashmap增加查询效率
        //封装中序遍历
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return myBuilderTree(preorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuilderTree(int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int root = preorder[preLeft];
        TreeNode treeNode = new TreeNode(root);
        int index = map.get(root);
        int leftSize = index - inLeft;
        treeNode.left = myBuilderTree(preorder, preLeft + 1, preLeft + leftSize, inLeft, index - 1);
        treeNode.right = myBuilderTree(preorder, preLeft + leftSize + 1, preRight, index + 1, inRight);
        return treeNode;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
