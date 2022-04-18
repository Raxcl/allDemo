package raxcl.math;


import java.util.*;

import static java.awt.SystemColor.info;

/**
 * @author D30100_chenlong
 * @date 2022/4/11 10:52
 */
public class test {
    public static void main(String[] args) {
        System.out.println(mostCommonWord("a.",new String[]{}));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        //划分单词为数组
        //1. 遍历，获取需要字符
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        Map<String,Integer> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        int max = 0;
        String maxStr = null;
        for (int i = 0; i <= paragraph.length(); i++) {
            if(i<paragraph.length() && Character.isLetter(paragraph.charAt(i))){
                stringBuilder.append(Character.toLowerCase(paragraph.charAt(i)));
            }else if(stringBuilder.length()>0){
                String word = stringBuilder.toString();
                if (!set.contains(word)){
                    int num = map.getOrDefault(word,0);
                    map.put(word,++num);
                    max = Math.max(max,num);
                }
                stringBuilder.setLength(0);
            }
        }
        //遍历map找出最大值
        Set<Map.Entry<String,Integer>> entries = map.entrySet();
        for(Map.Entry<String,Integer> entry: entries){
            if (max==entry.getValue()){
                maxStr = entry.getKey();
                break;
            }
        }
        return maxStr;
    }
}

