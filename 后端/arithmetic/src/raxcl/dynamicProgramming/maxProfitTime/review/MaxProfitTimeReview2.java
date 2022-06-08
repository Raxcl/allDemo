package raxcl.dynamicProgramming.maxProfitTime.review;

/**
 * 股票交易多次后的最大收益复习2
 *
 * @author D30100_chenlong
 * @date 2022-05-27 10:28:41
 */
public class MaxProfitTimeReview2 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 4, 8, 3, 9, 6, 7};
        System.out.println(maxProfitTime(prices,2));
    }

    private static int maxProfitTime(int[] prices, int k) {
        int n = prices.length;
        int m = k*2 +1;
        int[] result = new int[m];
        for (int i = 1; i < result.length; i+=2) {
            if ((i&1)==1){
                result[i] = -prices[0];
            }
        }
        for (int i = 0; i < prices.length; i++) {
            for(int j=m-1; j>0; j--){
                if ((j&1)==1){
                    result[j] = Math.max(result[j],result[j-1]-prices[i]);
                }else{
                    result[j] = Math.max(result[j],result[j-1]+prices[i]);
                }
            }
        }
        return result[m-1];
    }
}
