package raxcl.dynamicProgramming.maxProfitTime.review;

/**
 * @author D30100_chenlong
 * @date 2023/2/13 18:46
 */
public class MaxProfitTimeReviewAll {
    public static void main(String[] args) {
        int[] prices = {1, 2, 4, 8, 3, 9, 6, 7};
        System.out.println(maxProfitFor2Time(prices,2));
    }

    private static int maxProfitFor2Time(int[] prices, int k) {
        int n = prices.length;
        int m = k*2 +1;
        int[][] resultTable = new int[n][m];
        resultTable[0][1] = - prices[0];
        resultTable[0][3] = - prices[0];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if ((j&1) == 1) {
                    resultTable[i][j] = Math.max(resultTable[i-1][j], resultTable[i-1][j-1] - prices[i]);

                } else {
                    resultTable[i][j] = Math.max(resultTable[i-1][j], resultTable[i-1][j-1] + prices[i]);
                }
            }
        }
        return resultTable[n-1][m-1];

    }

}
