package raxcl.math.removeKDigits.review;

/**
 * 删除k个数后的最小值复习5
 *
 * @author D30100_chenlong
 * 2022-05-18 11:43:21
 */
public class RemoveKDigitsReview5 {
    public static void main(String[] args) {
        System.out.println(removeKDigits("1593212",3));
        System.out.println(removeKDigits("30200",1));
        System.out.println(removeKDigits("10",2));
        System.out.println(removeKDigits("541270936",3));
    }

    private static String removeKDigits(String s, int k) {
        //将s封装为char[]的过程中进行删除（跳过某数）
        char[] stack = new char[s.length()];
        //遍历s，将s的第一位放入char[]，定义一个指针index=0，
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //循环删除，如果char[]不为空，并且s的当前位小于index，如果k==0就跳出，index--，k--;
            while (index>0 && stack[index-1] > ch && k>0){
                index--;
                k--;
            }
            //全部封装
            stack[index++] = ch;
        }

        int startIndex = 0;
        while (startIndex<index && stack[startIndex]=='0'){
            startIndex++;
        }

        return startIndex==index? "0": new String(stack,startIndex,index-startIndex);
    }

}
