package raxcl.dynamicProgramming.review;

/**
 * 黄金矿工问题复习1
 *
 * @author D30100_chenlong
 * @date 2022/4/21 11:10
 */
public class GetBestGoldMiningReview1 {
    public static void main(String[] args) {
        int w = 10;
        int[] p = {5,5,3,4,3};
        int[] g = {400,500,200,300,350};
        System.out.println("最优收益："+ getBestGoldMining(w,p,g));
    }

    private static int getBestGoldMining(int w,int[] p, int[] g) {
        int[] array = new int[w+1];
        for (int i = 0; i < p.length; i++) {
            for (int j = array.length-1; j >=1; j--) {
                if (j>=p[i]){
                    array[j] = Math.max(array[j], array[j-p[i]]+g[i]);
                }
            }
        }
        return array[w];
    }
}
