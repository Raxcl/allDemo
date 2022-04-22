package raxcl.dynamicProgramming;

/**
 * 黄金矿工问题(求局部最优解的整体最优解）
 *
 * @author D30100_chenlong
 * @date 2022/4/18 15:51
 */
public class GetBestGoldMining {
    public static void main(String[] args) {
        int w = 10;
        int[] p = {5,5,3,4,3};
        int[] g = {400,500,200,300,350};
        System.out.println("最优收益："+ getBestGoldMining(w,g.length,p,g));
        System.out.println("最优收益："+ getBestGoldMining1(w,g.length,p,g));
        System.out.println("最优收益："+ getBestGoldMining2(w,p,g));
        System.out.println("最优收益："+ getBestGoldMining3(w,p,g));
    }

    /**
     * 获取金矿最优收益
     * @param w 工人数量
     * @param n 可选金矿数量
     * @param p 金矿开采所需的工人数量
     * @param g 金矿数量
     */
    public static int getBestGoldMining(int w, int n, int[] p, int[] g) {
        //如果工人数量没有了，或者金矿没有了，返回0;
        if (w==0 || n==0){
            return 0;
        }
        if (w<p[n-1]){
            //判断当前剩余工人数够不够挖这个矿，不够就n-1(可选金矿-1)
            return getBestGoldMining(w, n-1,p,g);
        }
        //选取挖和不挖的最大值，看谁的收益大
        return Math.max(
                //不挖最后一个矿
                getBestGoldMining(w,n-1,p,g),
                //挖最后一个矿
                //w-p[n-1]：减去挖矿走掉的人
                //n-1:减去这座矿
                //p: 所需工人的数组传进去
                //g,金矿收益数组传进去
                //g[n-1]:这座矿挖掉了，所以要加上收益
                getBestGoldMining(w-p[n-1],n-1,p,g)+g[n-1]);
    }

    //递归--动态规划--黄金矿工
    /**
     * 获取金矿最优收益
     * @param w 工人数量
     * @param n 可选金矿数量
     * @param p 金矿开采所需的工人数量
     * @param g 金矿数量
     */
    public static int getBestGoldMining1(int w, int n, int[] p, int[] g) {
        if (w==0 || n==0){
            return 0;
        }
        if (w<p[n-1]){
            return getBestGoldMining1(w, n-1, p, g);
        }
        return Math.max(getBestGoldMining1(w, n-1, p, g), getBestGoldMining1(w-p[n-1], n-1, p, g)+g[n-1]);
    }

    /**
     * 获取金矿最优收益 表格编写法
     * @param w 工人数量
     * @param p 金矿开采所需的工人数量
     * @param g 金矿数量
     */
    public static int getBestGoldMining2(int w, int[] p, int[] g) {
        //创建表格
        int[][] resultTable = new int[g.length+1][w+1];
        //填充表格
        for(int i=1; i<=g.length; i++){
            for(int j=1; j<=w; j++){
                if (j<p[i-1]){
                    resultTable[i][j] = resultTable[i-1][j];
                }else{
                    resultTable[i][j] = Math.max(resultTable[i-1][j],resultTable[i-1][j-p[i-1]]+g[i-1]);
                }
            }
        }
        return resultTable[g.length][w];
    }

    /**
     * 获取金矿最优收益 一行表格编写法
     * @param w 工人数量
     * @param p 金矿开采所需的工人数量
     * @param g 金矿数量
     */
    public static int getBestGoldMining3(int w, int[] p, int[] g) {
        //创建结果行
        int[] results = new int[w+1];
        //填充表格
        for(int i=1; i<=g.length; i++){
            for(int j=w; j>=1; j--){
                if (j>=p[i-1]){
                    results[j] = Math.max(results[j],results[j-p[i-1]]+g[i-1]);
                }
            }
        }
        return results[w];
    }
}
