package raxcl.dynamicProgramming.maxProfitTime.review;

/**
 * 股票交易多次后的最大收益复习4
 *
 * @author D30100_chenlong
 * @date 2022-06-07 11:27:15
 */
public class MaxProfitTimeReview4 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 4, 8, 3, 9, 6, 7};
        System.out.println(maxProfitTime(prices,2));
    }

    private static int maxProfitTime(int[] prices, int k) {
        int n = prices.length;
        int m = k*2+1;
        int[] result = new int[m];
        for (int i = 1; i < m; i+=2) {
            result[i] = -prices[0];
        }
        for (int i = 0; i < n; i++) {
            for (int j = m-1; j >0; j--) {
                result[j] = Math.max(result[j], (j&1)==0? result[j-1] +prices[i]: result[j-1] -prices[i]);
            }
        }
        return result[m-1];
    }
}
