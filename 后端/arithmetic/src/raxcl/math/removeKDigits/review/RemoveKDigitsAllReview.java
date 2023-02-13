package raxcl.math.removeKDigits.review;

public class RemoveKDigitsAllReview {
    public static void main(String[] args) {
        System.out.println(removeKDigits("1593212",3));
        System.out.println(removeKDigits("30200",1));
        System.out.println(removeKDigits("10",2));
        System.out.println(removeKDigits("541270936",3));
    }

    private static String removeKDigits(String num, int k) {
        int newLength = num.length() - k;
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (top >0 && stack[top - 1] > c && k >0) {
                top--;
                k--;
            }
            stack[top++] = c;
        }

        int offset = 0;
        while (offset < newLength && stack[offset] == '0') offset++;
        return offset == newLength ? "0": new String(stack, offset, newLength- offset);
    }
}
