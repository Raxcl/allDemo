package raxcl.stringdemo;

/**
 * 二进制表示中质数个计算置位
 *
 * @author D30100_chenlong
 * @date 2022/4/5 19:35
 */
public class CountPrimeSetBits {
    public static void main(String[] args) {
        CountPrimeSetBits c = new CountPrimeSetBits();
        System.out.println(c.countPrimeSetBits(6,10));
    }
    public int countPrimeSetBits(int left, int right) {
        //start 19:14
        //1. 遍历范围，将当前数转成二进制数,并对所有1相加，得到数num
        int sum = 0;
        for(int i=left; i<= right; i++){
            int num = 0;
            int tempI = i;
            while(tempI>=1){
                num += tempI%2==1 ? 1:0;
                tempI /= 2;
            }
            //2. 判断num是否为质数，若是质数，sum++;
            if(num == 2){
                sum++;
                continue;
            }
            for(int x=2; x<num; x++){
                if(num%x==0){
                    break;
                }
                if(x==num-1){
                    sum++;
                }
            }
        }
        //3. 返回sum；
        return sum;
    }
}
