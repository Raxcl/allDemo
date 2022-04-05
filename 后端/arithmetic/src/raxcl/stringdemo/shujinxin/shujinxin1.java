package raxcl.stringdemo.shujinxin;


import java.util.HashSet;
import java.util.Set;

/**
 * 赎金信  优化1
 * @author D30100_chenlong
 * @date 2022/3/28 23:03
 */
public class shujinxin1 {
    public static void main(String[] args) {
        shujinxin1 s = new shujinxin1();

        System.out.println(s.canConstruct("aa","aab"));

    }

    /**
     * 执行用时：
     * 13 ms
     * , 在所有 Java 提交中击败了
     * 12.71%
     * 的用户
     * 内存消耗：
     * 41.6 MB
     * , 在所有 Java 提交中击败了
     * 36.18%
     * 的用户
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        //start: 23:23
        //end: 23:33
        Set set = new HashSet();
        for(int i = 0;i<ransomNote.length();i++){
            int length = set.size();
            for(int j = 0;j<magazine.length();j++){
                if(ransomNote.charAt(i) == magazine.charAt(j)){
                    set.add(j);
                    if(length == set.size() -1 ){
                        break;
                    }

                }
            }
            if(length == set.size() ){
                return false;
            }
        }
        return true;
    }
}
