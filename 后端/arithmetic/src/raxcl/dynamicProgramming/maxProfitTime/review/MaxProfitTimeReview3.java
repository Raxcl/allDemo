package raxcl.dynamicProgramming.maxProfitTime.review;

/**
 * 股票交易多次后的最大收益复习3
 *
 * @author D30100_chenlong
 * @date 2022-05-31 10:15:44
 */
public class MaxProfitTimeReview3 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 4, 8, 3, 9, 6, 7};
        System.out.println(maxProfitTime(prices,2));
    }

    private static int maxProfitTime(int[] prices, int k) {
        int n = prices.length;
        int m = k*2+1;
        int[] resultArray = new int[m];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = (i&1)==0? 0: -prices[0];
        }
        for (int i = 0; i < n; i++) {
            for (int j = m-1; j >0 ; j--) {
                resultArray[j] = Math.max(resultArray[j], (j&1)==0? resultArray[j-1]+prices[i] :resultArray[j-1]-prices[i]);
            }
        }
        return resultArray[m-1];
    }
}
