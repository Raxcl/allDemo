package raxcl.stringdemo.iszero;

/**
 * 判断变为0的次数
 * @author D30100_chenlong
 * @date 2022/4/1 21:11
 */
public class IsZero {
    public int numberOfSteps(int num) {
        int s = 0;
        while(num!=0){
            if(num%2==0){
                num = num/2;
            }else {
                num = num -1;
            }
            s++;
        }
        return s;
    }

    public static void main(String[] args) {
        IsZero isZero = new IsZero();
        System.out.println(isZero.numberOfSteps(14));
    }
}
