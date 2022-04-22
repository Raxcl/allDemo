package raxcl.math.findLostNum;

/**
 * 找到丢失的整数
 *
 * @author D30100_chenlong
 * @date 2022/4/20 13:55
 */
public class FindLostNum {
    public static void main(String[] args) {
        int[] array = {4,1,2,2,5,1,4,3};
        int[] result = findLostNum(array);
        System.out.println(result[0]+","+result[1]);
    }

    private static int[] findLostNum(int[] array) {
        //异或所有数
        int sum = 0;
        for(int a:array){
            sum ^=a;
        }
        //从右向左找到不同位 &1==1
        int index=1;
        while((sum&index)==0){
            index <<=1;
        }
        //分别异或，最终结果就是答案
        int numberA = 0;
        int numberB = 0;
        for (int j : array) {
            //不能判断等于1,因为结果是2或0，一般这种情况要去判断0
            if ((j & index) == 0) {
                numberA ^= j;
            } else {
                numberB ^= j;
            }
        }
        return new int[]{numberA,numberB};
    }
}
