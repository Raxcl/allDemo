package raxcl.stringdemo.iszero;

/**
 * 判断变为0的次数 优化1（由于奇数-1再/2的结果等于奇数/2,所以并不需要减一的操作，只需要在奇数的时候对操作次数加一即可）
 * @author D30100_chenlong
 * @date 2022/4/1 21:11
 */
public class IsZero1 {
    public int numberOfSteps(int num) {
        //14 7 3 1
        //   1 3 5
        int s = 0;
        while(num!=0) {
            s += (num > 1 ? 1 : 0) + (num & 0x01);
            num >>= 1;
        }
        return s;
    }

    public static void main(String[] args) {
        IsZero1 isZero = new IsZero1();
        System.out.println(isZero.numberOfSteps(144));
    }
}
