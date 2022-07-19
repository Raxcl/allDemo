//设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。 
//
// 实现 WordFilter 类： 
//
// 
// WordFilter(string[] words) 使用词典中的单词 words 初始化对象。 
// f(string pref, string suff) 返回词典中具有前缀 prefix 和后缀 suff 的单词的下标。如果存在不止一个满足要求的下标，
//返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["WordFilter", "f"]
//[[["apple"]], ["a", "e"]]
//输出
//[null, 0]
//解释
//WordFilter wordFilter = new WordFilter(["apple"]);
//wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词：前缀 prefix = "a" 且 后缀 suff = "e" 。
//
// 
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 10⁴ 
// 1 <= words[i].length <= 7 
// 1 <= pref.length, suff.length <= 7 
// words[i]、pref 和 suff 仅由小写英文字母组成 
// 最多对函数 f 执行 10⁴ 次调用 
// 
// Related Topics 设计 字典树 字符串 👍 116 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//前缀和后缀搜索
public class PrefixAndSuffixSearch{
    public static void main(String[] args) {
//        WordFilter solution = new PrefixAndSuffixSearch().new WordFilter();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class WordFilter {
    //添加备忘录，增加效率
    HashMap<String, Integer> memo = new HashMap<>();

    String[] words;

    public WordFilter(String[] words) {
        this.words = words;
    }

    /**
     * 找到前后缀都匹配的单词，从后向前找，找到就返回下标，可能会超时，应该要加备忘录
     * 如何找？
     * 遍历数组
     * 前缀：用substring(0,pref.length())
     * 后缀：用substring(word.length()-suff.length())
     * @param pref
     * @param suff
     * @return
     */
    public int f(String pref, String suff) {
        String key = pref + "_" + suff;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        for (int i = words.length - 1; i >= 0; i--) {
            //补充判断，word长度需要大于等于pref和suff
            if (words[i].length() >= pref.length() &&
                words[i].length() >= suff.length() &&
                pref.equals(words[i].substring(0, pref.length())) &&
                suff.equals(words[i].substring(words[i].length() - suff.length()))
            ) {
                memo.put(key, i);
                return i;
            }
        }
        memo.put(key, -1);
        return -1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
