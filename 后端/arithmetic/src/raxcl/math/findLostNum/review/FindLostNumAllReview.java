package raxcl.math.findLostNum.review;

/**
 * @author Raxcl
 * @date 2023/2/12 19:45
 */
public class FindLostNumAllReview {
    public static void main(String[] args) {
        int[] array = {4,1,2,2,5,1,4,3};
        int[] result = findLostNum(array);
        System.out.println(result[0]+","+result[1]);
    }

    private static int[] findLostNum(int[] array) {
        int sum = 0;
        for (int a:array) {
            sum ^= a;
        }
        int index = 1;
        while ((sum&index) == 0){
            index <<=1;
        }
        int numberA = 0;
        int numberB = 0;
        for (int j: array){
            if ((index&j)==0) {
                numberA ^=j;

            }else {
                numberB ^=j;
            }
        }
        return new int[]{numberA,numberB};
    }


}
