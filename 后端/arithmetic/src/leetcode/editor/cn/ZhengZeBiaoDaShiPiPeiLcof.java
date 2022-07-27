//请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配
//是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。 
// 
//
// 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
// 
//
// Related Topics 递归 字符串 动态规划 👍 420 👎 0

package leetcode.editor.cn;

//正则表达式匹配
public class ZhengZeBiaoDaShiPiPeiLcof{
    public static void main(String[] args) {
        Solution solution = new ZhengZeBiaoDaShiPiPeiLcof().new Solution();
        solution.isMatch("aab", "c*a*b");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        /**
         * 模拟
         * 定义 int index1 指向 s的字符， index2 指向 p
         *  判断 p的字符，
         *  1. .
         *      后一位是 * ： 判断 * 是否是最后一位
         *          是最后一位： 返回 true
         *          不是最后一位： 判断后一位与 s 的匹配， 同时更新 index1
         *      后一位不是 * ：
         *         跳过一个字符
         *  2. 字母
         *       判断后一位是否是 *
         *           是，判断后一位， 是否为 a*a结构
         *              是，移动 index2
         *             开始匹配
         *           不是，直接匹配
         */
        int index1 = 0, index2 = 0;
        while (index1 < s.length() && index2 < p.length()) {
            char ch = p.charAt(index2);
            if (ch == '.') {
                if (index2 + 1 < p.length() && p.charAt(index2 + 1) == '*') {
                    if (index2 + 2 < p.length()) {
                        index2 = index2 + 2;
                        while (index1 < s.length() && s.charAt(index1) != p.charAt(index2)) {
                            index1++;
                        }
                        if (index1 == s.length()) {
                            return false;
                        }
                        // 更新到下一位
                        index1++;
                        // .* 结尾，return true
                    } else {
                        return true;
                    }
                }
                index1++;
            } else if (ch >= 'a' && ch <= 'z') {
                if (index2 + 1 < p.length() && p.charAt(index2 + 1) == '*') {
                    index2++;
                    if (index2 + 1 < p.length() && p.charAt(index2 + 1) == ch) {
                        index2++;
                    }
                    //匹配 *
                    while (index1 < s.length() && s.charAt(index1) == ch) {
                        index1++;
                    }
                } else {
                    //不等于，返回
                    if (s.charAt(index1) != ch) {
                        return false;
                    }
                    index1++;
                }
            }
            index2++;
        }
        if (index1 == s.length() && index2 == p.length()) {
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
