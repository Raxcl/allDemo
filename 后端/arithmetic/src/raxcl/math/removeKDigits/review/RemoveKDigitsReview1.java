package raxcl.math.removeKDigits.review;

/**
 * 删除k个数后的最小值复习1
 *
 * @author D30100_chenlong
 * @date 2022/4/19 14:47
 */
public class RemoveKDigitsReview1 {
    public static void main(String[] args) {
        System.out.println(removeKDigits("1593212",3));
        System.out.println(removeKDigits("30200",1));
        System.out.println(removeKDigits("10",2));
        System.out.println(removeKDigits("541270936",3));
    }

    private static String removeKDigits(String num, int k) {
        char[] stack = new char[num.length()];
        int newLength = num.length()-k;
        int top=0;
        for (int i = 0; i < num.length(); i++) {
            //遍历当前数字
            char c = num.charAt(i);
            //当栈顶元素大于当前元素，栈顶元素出栈（删除元素）
            while (top>0 && stack[top-1]>c && k>0){
                top--;
                k--;
            }
            //遍历当前元素入栈
            stack[top++] = c;
        }
        //找到栈中第一个非零数字的位置，以此构建新的整数字符串
        int offset = 0;
        //由于已经删除k个数了，所以stack中的实际长度是newLength
        while (offset<newLength && stack[offset]=='0'){
            offset++;
        }
        return offset==newLength? "0": new String(stack,offset,newLength-offset);
    }


}
