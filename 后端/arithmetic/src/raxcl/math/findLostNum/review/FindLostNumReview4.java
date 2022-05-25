package raxcl.math.findLostNum.review;

/**
 * 寻找丢失的整数复习4
 *
 * @author D30100_chenlong
 * @date 2022-05-09 10:43:35
 */
public class FindLostNumReview4 {
    public static void main(String[] args) {
        int[] array = {4,1,2,2,5,1,4,3};
        int[] result = findLostNum(array);
        System.out.println(result[0]+","+result[1]);
    }

    private static int[] findLostNum(int[] array) {
        //异或运算所有数，得到的数就是两个丢失的数之和
        int count = 0;
        for (int num : array){
            count ^= num;
        }
        //判断哪一位不同，据此划分数组为两份，分别异或，即可得到两个数
        int index=1;
        for (;(count&index)==0;index <<=1){

        }
        int[] result = new int[2];
        for (int num: array){
            if ((num&index)==0){
                result[0] ^= num;
            }else{
                result[1] ^= num;
            }
        }
        return result;

    }
}
