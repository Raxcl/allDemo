package raxcl.math.removeKDigits.review;

/**
 * 删除k个数后的最小值复习2
 *
 * @author D30100_chenlong
 * @date 2022/4/20 11:42
 */
public class RemoveKDigitsReview2 {
    public static void main(String[] args) {
        System.out.println(removeKDigits("1593212",3));
        System.out.println(removeKDigits("30200",1));
        System.out.println(removeKDigits("10",2));
        System.out.println(removeKDigits("541270936",3));
    }

    private static String removeKDigits(String s, int k) {

        char[] stack = new char[s.length()];
        int newLength = s.length()-k;
        int top=0;
        //遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //循环判断是否左大于小，删除
            while(top>0 && stack[top-1]>c && k>0){
                top--;
                k--;
            }
            //将其存入char[]数组
            stack[top++] = c;
        }
        int offset = 0;

        //定义有效位
        while(offset<newLength && stack[offset]=='0'){
            offset++;
        }
        //封装字符串
        return offset==newLength?"0":new String(stack,offset,newLength-offset);

        //如果k还有剩余，代表数组是顺序的,从右向左删除(省略）
    }

}
