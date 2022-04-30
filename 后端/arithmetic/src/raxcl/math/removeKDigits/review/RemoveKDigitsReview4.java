package raxcl.math.removeKDigits.review;

/**
 * 删除k个数后的最小值复习4
 *
 * @author D30100_chenlong
 * @date 2022-04-25 12:50:17
 */
public class RemoveKDigitsReview4 {
    public static void main(String[] args) {
        System.out.println(removeKDigits("1593212",3));
        System.out.println(removeKDigits("30200",1));
        System.out.println(removeKDigits("10",2));
        System.out.println(removeKDigits("541270936",3));
    }

    private static String removeKDigits(String s, int k) {
        char[] stack = new char[s.length()];
        int index=0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while(index>0 && stack[index-1]>ch && k>0){
                index--;
                k--;
            }
            stack[index++] = ch;
        }
        int start = 0;
        while(start<index && stack[start] =='0'){
            start++;
        }
        return start==index?"0":new String(stack, start, index-start);

    }

}
