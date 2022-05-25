package raxcl.dynamicProgramming.maxProfitTime;

/**
 * 股票一次买卖的最大收益
 *
 * @author D30100_chenlong
 * @date 2022/5/24 14:28
 */
public class MaxProfitTime {
    public static void main(String[] args) {
        int[] prices = {1, 2, 4, 8, 3, 9, 6, 7};
        System.out.println(maxProfitFor2Time1(prices,2));
    }

    private static int maxProfitFor1Time(int[] prices) {
        //从下标1开始遍历
        int minValue = prices[0];
        //记录收益最大值
        int maxMoney = -1;
        for (int i = 1; i < prices.length; i++) {
            //找到最小值，并记录位置
            if (prices[i]<minValue){
                minValue = prices[i];
            }
            maxMoney = Math.max(maxMoney, prices[i]-minValue);
        }
        return maxMoney;
    }

    //无限次
    private static int maxProfitFor1Time1(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            //找到最小值，并记录位置
            if (prices[i]>prices[i-1]){
                sum += prices[i] - prices[i-1];
            }
        }
        return sum;
    }

    //最大买卖次数
    private static int MAX_DEAL_TIMES = 2;

    //两次买卖
    private static int maxProfitFor2Time(int[] prices) {
        //表格的最大行数
        int n = prices.length;
        //表格的最大列数
        int m = MAX_DEAL_TIMES*2+1;
        //使用二维数组记录数据
        int[][] resultTable = new int[n][m];
        //填充初始状态
        resultTable[0][1] = - prices[0];
        resultTable[0][3] = - prices[0];
        //自底向上,填充数据
        //第几天
        for (int i = 1; i < n; i++) {
            //买卖状态
            for (int j = 1; j < m; j++) {
                if ((j&1)==1){
                    //奇数，第一次买入和第二次买入
                    resultTable[i][j] = Math.max(resultTable[i-1][j], resultTable[i-1][j-1]-prices[i]);
                }else{
                    //卖出
                    resultTable[i][j] = Math.max(resultTable[i-1][j],resultTable[i-1][j-1]+prices[i]);
                }
            }
        }
        //返回最终结果
        return resultTable[n-1][m-1];
    }

    //两次买卖--优化空间
    private static int maxProfitFor2Time1(int[] prices,int k) {
        //表格的最大行数
        int n = prices.length;
        //表格的最大列数
        int m = k*2+1;
        //使用二维数组记录数据
        int[] resultTable = new int[m];
        //填充初始状态
        resultTable[1] = - prices[0];
        resultTable[3] = - prices[0];
        //自底向上,填充数据
        //第几天
        for (int i = 1; i < n; i++) {
            //买卖状态
            for (int j = m-1; j >= 1; j--) {
                if ((j&1)==1){
                    //奇数，第一次买入和第二次买入
                    resultTable[j] = Math.max(resultTable[j], resultTable[j-1]-prices[i]);
                }else{
                    //卖出
                    resultTable[j] = Math.max(resultTable[j],resultTable[j-1]+prices[i]);
                }
            }
        }
        //返回最终结果
        return resultTable[m-1];
    }

}
