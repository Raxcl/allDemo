package raxcl.stringdemo.shujinxin;


/**
 * 赎金信  优化2 通过26个字母的数组来计数
 * @author D30100_chenlong
 * @date 2022/3/28 23:03
 */
public class shujinxin2 {
    public static void main(String[] args) {
        shujinxin2 s = new shujinxin2();

        System.out.println(s.canConstruct("aa","aab"));

    }
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        int[] cnt = new int[26];
        for(char c: magazine.toCharArray()){
            cnt[c-'a']++;
        }
        for(char c : ransomNote.toCharArray()){
            cnt[c-'a']--;
            if(cnt[c-'a']<0){
                return false;
            }
        }
        return true;
    }

}
