package raxcl.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author D30100_chenlong
 * @date 2022/6/24 12:14
 */
public class test {
    public static void main(String[] args) {
        test t = new test();
        String str1="wordgoodgoodgoodbestword";
        String[] str2=new String[]{"word","good","best","good"};
        List<Integer> barfoothefoobarman = t.findSubstring(str1,str2);
        System.out.println(barfoothefoobarman);
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> resultList = new ArrayList<>();
        //滑动窗口解决+map哈希表
        //初始化map
        Map<String, Integer> map = new HashMap<>();
        int sLen = s.length(), wLen = words.length, zwLen=words[0].length();
        //子串
        for(int i=0; i<wLen; i++){
            map.put(words[i],map.get(words[i])==null? 1 : map.get(words[i])+1);
        }

        //滑动窗口
        for (int i = 0; i < sLen-wLen*zwLen+1; i++) {
                //构造字符串数组
                String[] strs = new String[wLen];
                int index=0;
                for (int j = i; j < i+wLen*zwLen; j +=zwLen) {
                    strs[index++] = s.substring(j, j +zwLen);
                }
                //克隆map
                Map<String,Integer> tempMap = new HashMap<>();
                Set<String> set1 = map.keySet();
                for (String s1: set1){
                    tempMap.put(s1, map.get(s1));
                }
                //主串的子串遍历
                boolean flag1 = true;
                for(String s1: strs){
                    if (tempMap.get(s1)==null){
                        flag1 = false;
                        break;
                    }else{
                        tempMap.put(s1, tempMap.get(s1)-1);
                    }
                }
                //不匹配
                if (!flag1){
                    continue;
                }
                //检查tempMap是否都为0
                //判断map是否全为0
                Set<String> set = tempMap.keySet();
                boolean flag = true;
                for(String key: set){
                    if (tempMap.get(key)!=0){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    resultList.add(i);
                }
            }
        return resultList;
    }
}
