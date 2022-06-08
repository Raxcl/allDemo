package raxcl.dynamicProgramming.getBestGoldMining.review;

/**
 * 黄金矿工问题复习5
 *
 * @author D30100_chenlong
 * @date 2022-05-26 17:16:32
 */
public class GetBestGoldMiningReview5 {
    public static void main(String[] args) {
        int w = 10;
        int[] p = {5,5,3,4,3};
        int[] g = {400,500,200,300,350};
        System.out.println("最优收益："+ getBestGoldMining(w,p,g));
    }

    private static int getBestGoldMining(int w,int[] p, int[] g) {
        int[] result = new int[w+1];
        for (int i = 0; i < p.length; i++) {
            for (int j = w; j> 0; j--) {
                if (j>=p[i]){
                    result[j] = Math.max(result[j], result[j-p[i]]+g[i]);
                }
            }
        }
        return result[w];
    }
}
