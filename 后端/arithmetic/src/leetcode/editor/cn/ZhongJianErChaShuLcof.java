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
        // 找出中序中间节点
        // 遍历中序
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        // 根节点
        int root = preorder[preLeft];
        TreeNode node = new TreeNode(root);
        int inRootIndex = map.get(root);
        int leftSize = inRootIndex - inLeft;
        node.left = myBuildTree(preorder, preLeft + 1, preLeft + leftSize, inLeft, inRootIndex - 1);
        node.right = myBuildTree(preorder, preLeft + leftSize + 1, preRight, inRootIndex + 1, inRight);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
