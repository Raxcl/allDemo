package raxcl.math.removeKDigits.review;

/**
 * 删除k个数后的最小值复习3
 *
 * @author D30100_chenlong
 * @date 2022/4/20 11:42
 */
public class RemoveKDigitsReview3 {
    public static void main(String[] args) {
        System.out.println(removeKDigits("1593212",3));
        System.out.println(removeKDigits("30200",1));
        System.out.println(removeKDigits("10",2));
        System.out.println(removeKDigits("541270936",3));
    }

    private static String removeKDigits(String s, int k) {
        char[] stack = new char[s.length()];
        stack[0] = s.charAt(0);
        int index=0;
        for (int i = 0; i < s.length(); i++) {
            char c =s.charAt(i);
            while( index>0 && stack[index-1]>c && k>0){
                index--;
                k--;
            }
            stack[index++] = c;
        }
        int noZero = 0;
        while (noZero<index && stack[noZero]=='0'){
            noZero++;
        }
        return noZero==index?"0":new String(stack,noZero,index-noZero);
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = noZero; i < index; i++) {
//            stringBuilder.append(stack[i]);
//        }
//        return stringBuilder.toString();

    }

}
