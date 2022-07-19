//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 👍 640 👎 0

package leetcode.editor.cn;

//矩阵中的路径
public class JuZhenZhongDeLuJingLcof{
    public static void main(String[] args) {
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
        System.out.println(solution.exist(new char[][]{{'a', 'b', 'c', 'd'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}}, "abcd"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        // 回溯 ， 遍历找出每个首字母相同，找四周，判断与word的index位是否相符，并回溯
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(used, board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(boolean[][] used, char[][] board, String word, int index, int i, int j) {
        if (word.length() == index) {
            return true;
        }
        // 判断相等，进入下一步，否则返回false
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || used[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        }
        used[i][j] = true;
        //回溯（上下左右）
        boolean res = dfs(used, board, word, index + 1, i - 1, j) ||
                dfs(used, board, word, index + 1, i + 1, j) ||
                dfs(used, board, word, index + 1, i, j - 1) ||
                dfs(used, board, word, index + 1, i, j + 1);
        used[i][j] = false;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
