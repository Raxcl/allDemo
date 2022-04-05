package raxcl.stringdemo.shujinxin;


import java.util.ArrayList;

/**
 * 赎金信
 * @author D30100_chenlong
 * @date 2022/3/28 23:03
 */
public class shujinxin {
    public static void main(String[] args) {
        String str = "aaa";
        String[] split = str.split("");
        ArrayList<Integer> list = new ArrayList<Integer>();

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
        //start 22:20

        //start2: 23:00
        //end2: 23:20


        //1. 将magazine存入list中
        ArrayList<Character> list = new ArrayList<Character>();
        for(int i = 0;i<magazine.length();i++){
            list.add(magazine.charAt(i));
        }
        //2. for遍历ransomNote
        for(int i = 0;i<ransomNote.length();i++){
            for(int j = 0;j<list.size();j++){
                if(ransomNote.charAt(i) == list.get(j)){
                    list.remove(j);
                    break;
                }
                if(j == list.size()-1){
                    return false;
                }
            }

        }
        return true;
    }
}
