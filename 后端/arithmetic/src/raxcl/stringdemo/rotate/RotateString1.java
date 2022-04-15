package raxcl.stringdemo.rotate;

/**
 * 优化1
 *
 * @author D30100_chenlong
 * @date 2022/4/7 10:10
 */
public class RotateString1 {
    public static void main(String[] args) {
        RotateString1 r =new RotateString1();
        System.out.println(r.rotateString("clrwmpkwru","wmpkwruclr"));;
    }
    public boolean rotateString(String s, String goal) {
        int m = s.length(), n = goal.length();
        if (m != n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (s.charAt((i + j) % n) != goal.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
