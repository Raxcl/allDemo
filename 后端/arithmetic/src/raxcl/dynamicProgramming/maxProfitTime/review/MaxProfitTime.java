package raxcl.dynamicProgramming.maxProfitTime.review;

/**
 * 股票交易多次后的最大收益
 *
 * @author D30100_chenlong
 * @date 2022/5/25 15:43
 */
public class MaxProfitTime {
    public static void main(String[] args) {
        int[] prices = {1, 2, 4, 8, 3, 9, 6, 7};
        System.out.println(maxProfitTime(prices,2));
    }

    private static int maxProfitTime(int[] prices, int k) {
        int n = k*2+1;
        int[] resultArray = new int[n];
        //定义初始状态
        for (int i = 1; i < n; i += 2) {
            resultArray[i] = -prices[0];
        }
        for (int i = 0; i < prices.length; i++) {
            for (int j = resultArray.length-1; j >0 ; j--) {
                if ((j&1)==1){
                    resultArray[j] = Math.max(resultArray[j],resultArray[j-1]-prices[i]);
                }else{
                    resultArray[j] = Math.max(resultArray[j],resultArray[j-1]+prices[i]);
                }
            }
        }
        return resultArray[n-1];
    }
}
